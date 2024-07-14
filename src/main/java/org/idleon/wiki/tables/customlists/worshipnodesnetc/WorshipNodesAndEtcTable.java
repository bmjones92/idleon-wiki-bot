package org.idleon.wiki.tables.customlists.worshipnodesnetc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class WorshipNodesAndEtcTable extends ArrayGameTable<List<List<Integer>>> {

    public WorshipNodesAndEtcTable(@NonNull Collection<List<List<Integer>>> items) {
        super(items);
    }

}
