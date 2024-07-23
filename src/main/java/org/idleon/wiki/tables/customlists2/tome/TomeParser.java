package org.idleon.wiki.tables.customlists2.tome;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class TomeParser extends DataTableParser<List<List<String>>, TomeTable> {

    public TomeParser() {
        super("scripts.CustomLists2", "Tome");
    }

    @Override
    protected TomeTable parseData(@NonNull List<List<String>> input) {
        return new TomeTable(input.stream().map(this::parseTask).toList());
    }

    private TomeTable.TomeTask parseTask(@NonNull List<String> input) {
        final var title = parseTitle(input.get(0));
        final var x1 = Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var x3 = Integer.parseInt(input.get(3));
        final var tooltip = !input.get(5).equals("filler")
                ? TextTransformers.SPACES.transform(input.get(5))
                : null;
        return new TomeTable.TomeTask(title, x1, x2, x3, tooltip);
    }

    private String parseTitle(@NonNull String input) {
        final var index = input.indexOf('\u819B');
        if (index != -1) {
            input = input.substring(0, index - 1);
        }
        return TextTransformers.SPACES.transform(input);
    }

}
