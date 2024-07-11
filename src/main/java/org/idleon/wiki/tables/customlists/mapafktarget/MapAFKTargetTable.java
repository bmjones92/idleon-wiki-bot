package org.idleon.wiki.tables.customlists.mapafktarget;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class MapAFKTargetTable extends ArrayGameTable<String> {

    public MapAFKTargetTable(@NonNull Collection<String> items) {
        super(items);
    }

}
