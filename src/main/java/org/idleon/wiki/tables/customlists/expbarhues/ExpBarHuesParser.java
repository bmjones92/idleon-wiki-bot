package org.idleon.wiki.tables.customlists.expbarhues;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ExpBarHuesParser extends DataTableParser<List<Integer>, ExpBarHuesTable> {

    public ExpBarHuesParser() {
        super("scripts.CustomLists", "ExpBarHues");
    }

    @Override
    protected ExpBarHuesTable parseData(@NonNull List<Integer> input) {
        return new ExpBarHuesTable(input);
    }

}
