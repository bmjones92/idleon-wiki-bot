package org.idleon.wiki.tables.customlists2.sailingmappaths;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.Position;

import java.util.Collection;
import java.util.List;

public class SailingMapPathsTable extends ArrayGameTable<List<Position>> {

    public SailingMapPathsTable(@NonNull Collection<List<Position>> items) {
        super(items);
    }

}
