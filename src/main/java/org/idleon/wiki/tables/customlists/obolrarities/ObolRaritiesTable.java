package org.idleon.wiki.tables.customlists.obolrarities;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class ObolRaritiesTable extends ArrayGameTable<String> {
    
    public ObolRaritiesTable(@NonNull Collection<String> items) {
        super(items);
    }

}
