package org.idleon.wiki.tables.customlists.bgselectorder;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class BGSelectOrderParser extends DataTableParser<List<Integer>, BGSelectOrderTable> {

    public BGSelectOrderParser() {
        super("scripts.CustomLists", "BGselectOrder");
    }

    @Override
    protected BGSelectOrderTable parseData(@NonNull List<Integer> input) {
        return new BGSelectOrderTable(input);
    }

}
