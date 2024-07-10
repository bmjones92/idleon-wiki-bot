package org.idleon.wiki.tables.customlists.classnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class ClassNamesParser extends DataTableParser<List<String>, ClassNamesTable> {

    public ClassNamesParser() {
        super("scripts.CustomLists", "ClassNames");
    }

    @Override
    protected ClassNamesTable parseData(@NonNull List<String> input) {
        return new ClassNamesTable(input.stream().map(this::formatName).toList());
    }

    private String formatName(@NonNull String name) {
        if (name.equals("0") || name.equals("FILLER")) {
            return null;
        }
        return TextTransformers.TITLE.transform(name);
    }

}
