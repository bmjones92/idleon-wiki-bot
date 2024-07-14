package org.idleon.wiki.tables.customlists2.anvilrecipehints;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class AnvilRecipeHintsParser extends DataTableParser<List<List<String>>, AnvilRecipeHintsTable> {

    public AnvilRecipeHintsParser() {
        super("scripts.CustomLists2", "AnvilRecipeHints");
    }

    @Override
    protected AnvilRecipeHintsTable parseData(@NonNull List<List<String>> input) {
        return new AnvilRecipeHintsTable(input.stream().map(this::parseAnvilTab).toList());
    }

    private List<String> parseAnvilTab(@NonNull List<String> anvilTab) {
        return anvilTab.stream().map(this::parseHint).toList();
    }

    private String parseHint(@NonNull String hint) {
        return !hint.equals("_") ? TextTransformers.SPACES.transform(hint) : null;
    }

}
