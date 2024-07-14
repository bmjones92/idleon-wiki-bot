package org.idleon.wiki.tables.customlists.speednames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SpeedNamesTable extends ArrayGameTable<String> {

    public SpeedNamesTable(@NonNull Collection<String> items) {
        super(items);
    }

}
