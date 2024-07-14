package org.idleon.wiki.tables.customlists.shoplocations;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class ShopLocationsTable extends ArrayGameTable<Integer> {

    public ShopLocationsTable(@NonNull Collection<Integer> items) {
        super(items);
    }

}
