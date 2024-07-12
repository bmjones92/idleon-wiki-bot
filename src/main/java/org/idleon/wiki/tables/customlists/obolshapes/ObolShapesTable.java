package org.idleon.wiki.tables.customlists.obolshapes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class ObolShapesTable extends ArrayGameTable<String> {

    public ObolShapesTable(@NonNull Collection<String> items) {
        super(items);
    }

}
