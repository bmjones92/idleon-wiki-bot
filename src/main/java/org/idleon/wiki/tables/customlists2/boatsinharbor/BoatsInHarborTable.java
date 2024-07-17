package org.idleon.wiki.tables.customlists2.boatsinharbor;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.Coordinate;

import java.util.Collection;

public class BoatsInHarborTable extends ArrayGameTable<Coordinate> {

    public BoatsInHarborTable(@NonNull Collection<Coordinate> items) {
        super(items);
    }

}
