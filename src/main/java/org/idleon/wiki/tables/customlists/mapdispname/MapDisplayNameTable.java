package org.idleon.wiki.tables.customlists.mapdispname;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class MapDisplayNameTable extends ArrayGameTable<String> {

    public MapDisplayNameTable(@NonNull Collection<String> items) {
        super(items);
    }

}
