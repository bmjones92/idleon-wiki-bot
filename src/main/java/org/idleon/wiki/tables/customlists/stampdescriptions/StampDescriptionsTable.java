package org.idleon.wiki.tables.customlists.stampdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class StampDescriptionsTable extends ArrayGameTable<List<String>> {

    public StampDescriptionsTable(@NonNull Collection<List<String>> items) {
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
