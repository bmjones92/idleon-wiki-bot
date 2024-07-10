package org.idleon.wiki.tables.customlists.alchemyvialitems;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class AlchemyVialItemsTable extends ArrayGameTable<String> {

    public AlchemyVialItemsTable(@NonNull Collection<String> items) {
        super(items);
    }

}
