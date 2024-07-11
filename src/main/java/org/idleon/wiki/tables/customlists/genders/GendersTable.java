package org.idleon.wiki.tables.customlists.genders;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class GendersTable extends ArrayGameTable<String> {

    public GendersTable(@NonNull Collection<String> items) {
        super(items);
    }

}
