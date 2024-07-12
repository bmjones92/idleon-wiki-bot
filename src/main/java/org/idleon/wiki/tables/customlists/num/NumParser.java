package org.idleon.wiki.tables.customlists.num;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class NumParser extends DataTableParser<List<String>, NumTable> {

    public NumParser() {
        super("scripts.CustomLists", "Num");
    }

    @Override
    protected NumTable parseData(@NonNull List<String> input) {
        return new NumTable(input.stream().map(line -> line.charAt(0)).toList());
    }

}
