package org.idleon.wiki.tables.customlists.scenenpcnodes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class SceneNPCNodesTable extends ArrayGameTable<List<Integer>> {

    public SceneNPCNodesTable(@NonNull Collection<List<Integer>> items) {
        super(items);
    }

}
