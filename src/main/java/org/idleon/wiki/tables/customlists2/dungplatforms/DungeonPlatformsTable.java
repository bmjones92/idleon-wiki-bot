package org.idleon.wiki.tables.customlists2.dungplatforms;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class DungeonPlatformsTable extends ArrayGameTable<DungeonPlatformsTable.DungeonPlatform> {

    public DungeonPlatformsTable(@NonNull Collection<DungeonPlatform> items) {
        super(items);
    }

    public record DungeonPlatform(
            @NonNull List<Integer> x0,
            @NonNull List<List<Integer>> x1,
            @NonNull List<List<Integer>> x2,
            @NonNull List<List<Integer>> x3,
            @NonNull List<Integer> x4,
            @NonNull String description,
            @NonNull List<Integer> x6,
            @NonNull List<Integer> x7
    ) {}

}
