package org.idleon.wiki.parser;

import com.microsoft.playwright.Page;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A {@code DataTableParser} is responsible for loading data table scripts from the game code.
 * @param <S> The raw data type.
 * @param <T> The parsed data type.
 * @author Brendan Jones
 */
public abstract class DataTableParser<S, T extends GameTable> implements TableParser<T> {

    /**
     * The material of the script the fetch the data from.
     */
    private final String scriptName;

    /**
     * The material of the table to fetch the data from.
     */
    private final String tableName;

    /**
     * Creates a new DataTableParser instance.
     * @param scriptName The material of the script to fetch the data from.
     * @param tableName The material of the table to fetch the data from.
     */
    public DataTableParser(@NonNull String scriptName, @NonNull String tableName) {
        this.scriptName = scriptName;
        this.tableName = tableName;
    }

    @Override
    public final T parse(@NonNull Page page) {
        @SuppressWarnings("unchecked")
        final var input = (S) page.evaluate(String.format("game['%s']['%s']()", scriptName, tableName));
        return parseData(input);
    }

    @Override
    public Path getExportPath() {
        return Paths.get(scriptName, tableName + ".json");
    }

    /**
     * Transforms the raw input data into the parsed output table.
     * @param input The input data.
     * @return The parsed table.
     */
    protected abstract T parseData(@NonNull S input);

}
