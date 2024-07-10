package org.idleon.wiki.tables.customlists.classnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class ClassNamesTable extends ArrayGameTable<String> {

    public ClassNamesTable(@NonNull Collection<String> items) {
        super(items);
    }

}
