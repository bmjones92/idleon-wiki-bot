package org.idleon.wiki.tables.customlists2.slabitemsort;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class SlabItemSortParser extends DataTableParser<List<String>, SlabItemSortTable> {

    public SlabItemSortParser() {
        super("scripts.CustomLists2", "SlabItemSort");
    }

    @Override
    protected SlabItemSortTable parseData(@NonNull List<String> input) {
        return new SlabItemSortTable(input);
    }

}
