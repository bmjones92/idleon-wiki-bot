package org.idleon.wiki.tables;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayGameTable<T> extends ArrayList<T> implements GameTable {

    public ArrayGameTable(@NonNull Collection<T> items) {
        super(items);
    }

}
