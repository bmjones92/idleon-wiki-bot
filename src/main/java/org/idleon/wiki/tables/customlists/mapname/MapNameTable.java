package org.idleon.wiki.tables.customlists.mapname;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class MapNameTable extends ArrayGameTable<String> {

    public MapNameTable(@NonNull Collection<String> items) {
        super(items);
    }

}
