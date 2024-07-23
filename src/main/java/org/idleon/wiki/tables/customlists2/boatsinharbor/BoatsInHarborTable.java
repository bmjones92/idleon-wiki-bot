package org.idleon.wiki.tables.customlists2.boatsinharbor;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.Position;

import java.util.Collection;

public class BoatsInHarborTable extends ArrayGameTable<Position> {

    public BoatsInHarborTable(@NonNull Collection<Position> items) {
        super(items);
    }

}
