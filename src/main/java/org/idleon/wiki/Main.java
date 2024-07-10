package org.idleon.wiki;

import org.idleon.wiki.config.AppConfig;
import org.idleon.wiki.registry.Registries;
import org.idleon.wiki.scraper.GameScraper;
import org.idleon.wiki.task.TaskRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static final Path CONFIG_PATH = Paths.get("config", "config.json");

    public static void main(String[] args) throws IOException {
        final var config = AppConfig.load(CONFIG_PATH);

        Registries.initialize();

        LOGGER.info("Initializing data scraper...");
        try (final var scraper = new GameScraper(config)) {
            Registries.getRegistry(TaskRegistry.class).items().forEach(task -> {
                LOGGER.info("Running task: {}", task.getClass().getSimpleName());
                task.execute(config, scraper);
            });
        }
    }

}
