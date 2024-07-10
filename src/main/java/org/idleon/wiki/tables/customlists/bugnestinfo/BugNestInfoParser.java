package org.idleon.wiki.tables.customlists.bugnestinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class BugNestInfoParser extends DataTableParser<List<List<Integer>>, BugNestInfoTable> {

    public BugNestInfoParser() {
        super("scripts.CustomLists", "BugNestInfo");
    }

    @Override
    protected BugNestInfoTable parseData(@NonNull List<List<Integer>> input) {
        return new BugNestInfoTable(input.stream().map(info -> {
            final var x0 = info.get(0);
            final var x1 = info.get(1);
            final var x2 = info.get(2);
            return new BugNestInfoTable.BugNestInfo(x0, x1, x2);
        }).toList());
    }

}
