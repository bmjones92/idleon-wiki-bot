package org.idleon.wiki.tables.customlists.animationoffsets;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class AnimationOffsetsTable extends ArrayGameTable<List<Integer>> {

    public AnimationOffsetsTable(@NonNull Collection<List<Integer>> items) {
        super(items);
    }

}
