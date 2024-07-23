package org.idleon.wiki.tables.customlists2.unlockinrngitems;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class UnlockingRNGItemsTable extends ArrayGameTable<Integer> {

    public UnlockingRNGItemsTable(@NonNull Collection<Integer> items) {
        super(items);
    }

}
