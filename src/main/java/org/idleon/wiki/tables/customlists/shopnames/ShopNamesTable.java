package org.idleon.wiki.tables.customlists.shopnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class ShopNamesTable extends ArrayGameTable<List<String>> {

    public ShopNamesTable(@NonNull Collection<List<String>> items) {
        super(items);
    }

}
