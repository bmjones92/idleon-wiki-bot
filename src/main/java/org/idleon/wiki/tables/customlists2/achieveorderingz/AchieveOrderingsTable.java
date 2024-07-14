package org.idleon.wiki.tables.customlists2.achieveorderingz;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class AchieveOrderingsTable extends ArrayGameTable<List<Integer>> {

    public AchieveOrderingsTable(@NonNull Collection<List<Integer>> items) {
        super(items);
    }

}
