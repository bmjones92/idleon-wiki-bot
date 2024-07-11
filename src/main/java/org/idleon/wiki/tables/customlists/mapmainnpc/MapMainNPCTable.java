package org.idleon.wiki.tables.customlists.mapmainnpc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class MapMainNPCTable extends ArrayGameTable<String> {

    public MapMainNPCTable(@NonNull Collection<String> items) {
        super(items);
    }

}
