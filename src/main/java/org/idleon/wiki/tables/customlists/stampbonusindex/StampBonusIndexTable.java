package org.idleon.wiki.tables.customlists.stampbonusindex;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class StampBonusIndexTable extends ArrayGameTable<List<String>> {

    public StampBonusIndexTable(@NonNull Collection<List<String>> items) {
        super(items);
    }

    public List<String> getCombatStamps() {
        return get(0);
    }

    public List<String> getSkillStamps() {
        return get(1);
    }

    public List<String> getMiscStamps() {
        return get(2);
    }

}
