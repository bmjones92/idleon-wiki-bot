package org.idleon.wiki.tables.customlists.worldservernames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class WorldServerNamesTable extends ArrayGameTable<String> {

    public WorldServerNamesTable(@NonNull Collection<String> items) {
        super(items);
    }

}
