package org.idleon.wiki.tables.customlists.bossattacksequences;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class BossAttackSequencesTable extends ArrayGameTable<List<Integer>> {

    public BossAttackSequencesTable(@NonNull Collection<List<Integer>> items) {
        super(items);
    }

}
