package org.idleon.wiki.tables.customlists.classpromotionchoices;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class ClassPromotionChoicesTable extends ArrayGameTable<List<Integer>> {

    public ClassPromotionChoicesTable(@NonNull Collection<List<Integer>> items) {
        super(items);
    }

}
