package org.idleon.wiki.tables.customlists2.dungenhanceinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class DungeonEnhanceInfoTable extends ArrayGameTable<List<String>> {

    public DungeonEnhanceInfoTable(@NonNull Collection<List<String>> items) {
        super(items);
    }

    public List<String> weapons() {
        return get(0);
    }

    public List<String> armor() {
        return get(1);
    }

    public List<String> jewelry() {
        return get(2);
    }

}
