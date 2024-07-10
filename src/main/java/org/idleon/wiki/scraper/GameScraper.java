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
import java.util.Map;

/**
 * A GameScraper is responsible for fetching and scraping.
 */
public class GameScraper implements AutoCloseable {

    private final Map<Class<?>, GameTable> tables = new HashMap<>();

    private final AppConfig config;

    private final Playwright playwright;

    private final Browser browser;

    private final Page page;

    public GameScraper(@NonNull AppConfig config) {
        this.config = config;
        this.playwright = Playwright.create();
        this.browser = playwright.chromium().launch(createLaunchOptions());
        this.page = browser.newPage();

        page.route(config.getScriptURL(), route -> {
            final var script = patchGameScript(config.getScriptURL());
            route.fulfill(new Route.FulfillOptions().setBody(script));
        });

        page.navigate(config.baseURL(), new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    /**
     * Creates the launch options for the browser.
     * @return The launch options.
     */
    private BrowserType.LaunchOptions createLaunchOptions() {
        final var options = new BrowserType.LaunchOptions();
        options.setHeadless(config.isHeadless());
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

    @Override
    public void close() {
        playwright.close();
    }

}
