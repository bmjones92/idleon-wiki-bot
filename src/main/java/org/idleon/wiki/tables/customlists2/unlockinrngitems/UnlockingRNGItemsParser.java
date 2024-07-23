package org.idleon.wiki.tables.customlists2.unlockinrngitems;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class UnlockingRNGItemsParser extends DataTableParser<List<Integer>, UnlockingRNGItemsTable> {

    public UnlockingRNGItemsParser() {
        super("scripts.CustomLists2", "UnlockinRNGitems");
    }

    @Override
    protected UnlockingRNGItemsTable parseData(@NonNull List<Integer> input) {
        return new UnlockingRNGItemsTable(input);
    }

}
