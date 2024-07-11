package org.idleon.wiki.tables.customlists.itemtocraftname;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class ItemToCraftNameTable extends ArrayGameTable<List<String>> {

    public ItemToCraftNameTable(@NonNull Collection<List<String>> items) {
        super(items);
    }

    public List<String> getAnvilTab(int tab) {
        return get(tab);
    }

}
