package org.idleon.wiki.parser;

import com.google.common.reflect.TypeToken;
import com.microsoft.playwright.Page;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.nio.file.Path;

/**
 * Script parsers are responsible for fetching and processing game script data.
 * @param <T> The resulting table.
 */
public interface TableParser<T extends GameTable> {

    /**
     * Scrapes the script data from the page and outputs the processed data.
     * @param page The page to scrape with.
     * @return The processed script.
     */
    T parse(@NonNull Page page);

    /**
     * Gets the export path relative to the root export path for the table parsed by this parser.
     * @return The export path.
     */
    Path getExportPath();

    /**
     * The table type that this parser produces.
     * @return The output table class.
     */
    default Class<T> getTableClass() {
        @SuppressWarnings("unchecked")
        final var result = (Class<T>) new TypeToken<T>(getClass()){}.getRawType();
        return result;
    }

}
