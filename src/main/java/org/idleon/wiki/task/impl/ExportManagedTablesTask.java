package org.idleon.wiki.task.impl;

import com.google.gson.GsonBuilder;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.config.AppConfig;
import org.idleon.wiki.parser.TableParserRegistry;
import org.idleon.wiki.registry.Registries;
import org.idleon.wiki.scraper.GameScraper;
import org.idleon.wiki.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;

public class ExportManagedTablesTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExportManagedTablesTask.class);

    @Override
    public void execute(@NonNull AppConfig config, @NonNull GameScraper scraper) {
        final var encoder = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        Registries.getRegistry(TableParserRegistry.class).items().forEach(parser -> {
            try {
                LOGGER.info("Parsing table: {}", parser.getClass().getSimpleName());

                final var table = scraper.getTable(parser);
                final var path = config.getExportPath().resolve(parser.getExportPath());
                Files.createDirectories(path.getParent());

                Files.writeString(path, encoder.toJson(table));
            } catch (IOException e) {
                LOGGER.error("Error while parsing table", e);
            }
        });
    }

}
