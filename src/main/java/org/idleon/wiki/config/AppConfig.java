package org.idleon.wiki.config;

import com.google.gson.GsonBuilder;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Application-wide configuration settings.
 * @param baseURL The base URL of the game.
 * @param projectName The internal project name of the game.
 * @param exportDirectory The root directory to place exported tables.
 * @param isHeadless Whether the scraper should be launched in headless mode.
 * @author Brendan Jones
 */
public record AppConfig(
        @NonNull String baseURL,
        @NonNull String projectName,
        @NonNull String exportDirectory,
        boolean isHeadless
) {

    /**
     * Gets the URL of the game script.
     * @return The game script URL.
     */
    public String getScriptURL() {
        return baseURL + "/" + projectName + ".js";
    }

    /**
     * Gets the root directory for exporting files.
     * @return The root directory.
     */
    public Path getExportPath() {
        return Paths.get(exportDirectory);
    }

    /**
     * Loads an AppConfig from the specified path.
     * @param path The config file path.
     * @return The loaded configuration.
     * @throws IOException If an error occurred while loading the file.
     */
    public static AppConfig load(@NonNull Path path) throws IOException {
        try (final var in = Files.newInputStream(path)) {
            final var gson = new GsonBuilder().create();
            return gson.fromJson(new InputStreamReader(in), AppConfig.class);
        }
    }

}
