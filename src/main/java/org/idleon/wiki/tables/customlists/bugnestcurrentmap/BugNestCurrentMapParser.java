package org.idleon.wiki.tables.customlists.bugnestcurrentmap;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class BugNestCurrentMapParser extends DataTableParser<List<Integer>, BugNestCurrentMapTable> {

    public BugNestCurrentMapParser() {
        super("scripts.CustomLists", "BugNestCurrentMap");
    }

    @Override
    protected BugNestCurrentMapTable parseData(@NonNull List<Integer> input) {
        return new BugNestCurrentMapTable(input);
    }

}
