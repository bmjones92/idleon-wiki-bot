package org.idleon.wiki.tables.customlists2.hints;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.hints.HintsTable.Hint;

import java.util.List;

public class HintsParser extends DataTableParser<List<List<List<String>>>, HintsTable> {

    public HintsParser() {
        super("scripts.CustomLists2", "Hints");
    }

    @Override
    protected HintsTable parseData(@NonNull List<List<List<String>>> input) {
        return new HintsTable(input.stream().map(this::parseWorldHints).toList());
    }

    private List<Hint> parseWorldHints(@NonNull List<List<String>> world) {
        return world.stream().map(this::parseHint).toList();
    }

    private Hint parseHint(@NonNull List<String> hint) {
        var title = TextTransformers.SPACES.transform(hint.get(0));
        var icon = Character.valueOf(title.charAt(title.length() - 1));
        if (!Character.isLetterOrDigit(icon) && !Character.isWhitespace(icon)) {
            icon = null;
        }
        final var description = List.of(TextTransformers.SPACES.transform(hint.get(1)).split("@"));
        return new Hint(title, icon, description);
    }

}
