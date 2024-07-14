package org.idleon.wiki.tables.customlists.shopqty;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class ShopQuantityTable extends ArrayGameTable<List<Integer>> {

    public ShopQuantityTable(@NonNull Collection<List<Integer>> items) {
        super(items);
    }

}
