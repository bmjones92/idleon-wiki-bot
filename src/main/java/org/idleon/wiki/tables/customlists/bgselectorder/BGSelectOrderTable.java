package org.idleon.wiki.tables.customlists.bgselectorder;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class BGSelectOrderTable extends ArrayGameTable<Integer> {

    public BGSelectOrderTable(@NonNull Collection<Integer> items) {
        super(items);
    }

}
