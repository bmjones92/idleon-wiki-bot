package org.idleon.wiki.scraper;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.config.AppConfig;
import org.idleon.wiki.parser.TableParser;
import org.idleon.wiki.parser.TableParserRegistry;
import org.idleon.wiki.registry.Registries;
import org.idleon.wiki.tables.GameTable;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A GameScraper is responsible for fetching and scraping data from the game code.
 */
public class GameScraper implements AutoCloseable {

    /**
     * Cache for tracking already parsed game tables.
     */
    private final Map<Class<?>, GameTable> tables = new HashMap<>();

    /**
     * The application configuration.
     */
    private final AppConfig config;

    /**
     * The playwright instance.
     */
    private final Playwright playwright;

    /**
     * The browser instance.
     */
    private final Browser browser;

    /**
     * The page instance.
     */
    private final Page page;

    /**
     * Creates a new GameScraper instance.
     * @param config The application configuration.
     */
    public GameScraper(@NonNull AppConfig config) {
        this.config = config;
        this.playwright = Playwright.create();
        this.browser = playwright.chromium().launch(createLaunchOptions());
        this.page = browser.newPage();

        // Intercept requests for the game script and patch it.
        page.route(config.getScriptURL(), route -> {
            final var script = patchGameScript(config.getScriptURL());
            route.fulfill(new Route.FulfillOptions().setBody(script));
        });

        // Navigate to the game page to kick off loading.
        page.navigate(config.baseURL(), new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    /**
     * Creates the launch options for the browser.
     * @return The launch options.
     */
    private BrowserType.LaunchOptions createLaunchOptions() {
        final var options = new BrowserType.LaunchOptions();
        options.setHeadless(config.isHeadless());
        options.setArgs(List.of("--mute-audio"));
        return options;
    }

    /**
     * Loads and patches the game script.
     * @param url The game script url.
     * @return The patched game script.
     */
    private String patchGameScript(@NonNull String url) {
        try (final var in = new URI(url).toURL().openStream()) {
            final var script = new String(in.readAllBytes());

            final var injectionPoint = script.indexOf("z.ApplicationMain");
            if (injectionPoint == -1) {
                throw new RuntimeException("Could not find injection point in game script.");
            }
            return script.substring(0, injectionPoint) + "window.game = z;" + script.substring(injectionPoint);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the table produced by the specified parser from the game code.
     * @param parser The parser instance to load with.
     * @return The parsed table.
     * @param <T> The table type.
     */
    public <T extends GameTable> T getTable(@NonNull TableParser<? extends T> parser) {
        @SuppressWarnings("unchecked")
        final var result = (T) tables.computeIfAbsent(parser.getClass(), type -> parser.parse(page));
        return result;
    }

    /**
     * Loads the specified table from the game code.
     * @param table The table class.
     * @return The parsed table.
     * @param <T> The table type.
     */
    public <T extends GameTable> T getTable(@NonNull Class<T> table) {
        final var parser = Registries.getRegistry(TableParserRegistry.class).getParserForTable(table);
        if (parser == null) {
            throw new NullPointerException("Could not find parser for table: " + table.getName());
        }
        return getTable(parser);
    }

    /**
     * Waits for the page to be closed manually.
     */
    public void waitForClose() {
        page.waitForClose(new Page.WaitForCloseOptions().setTimeout(0), () -> {});
    }

    @Override
    public void close() {
        playwright.close();
    }

}
