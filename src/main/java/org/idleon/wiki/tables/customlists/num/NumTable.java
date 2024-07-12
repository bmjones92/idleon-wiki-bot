package org.idleon.wiki.tables.customlists.num;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class NumTable extends ArrayGameTable<Character> {

    public NumTable(@NonNull Collection<Character> items) {
        super(items);
    }

}
