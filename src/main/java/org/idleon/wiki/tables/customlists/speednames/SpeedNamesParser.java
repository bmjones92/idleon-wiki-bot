package org.idleon.wiki.tables.customlists.speednames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class SpeedNamesParser extends DataTableParser<List<String>, SpeedNamesTable> {

    public SpeedNamesParser() {
        super("scripts.CustomLists", "SpeedNames");
    }

    @Override
    protected SpeedNamesTable parseData(@NonNull List<String> input) {
        return new SpeedNamesTable(input.stream().map(TextTransformers.TITLE::transform).toList());
    }

}
