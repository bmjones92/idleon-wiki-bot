package org.idleon.wiki.tables.customlists2.slabitemsort;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SlabItemSortTable extends ArrayGameTable<String> {

    public SlabItemSortTable(@NonNull Collection<String> items) {
        super(items);
    }

}
