package org.idleon.wiki.tables.customlists.nonafkmonsters;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class NonAFKMonstersTable extends ArrayGameTable<String> {

    public NonAFKMonstersTable(@NonNull Collection<String> items) {
        super(items);
    }

}
