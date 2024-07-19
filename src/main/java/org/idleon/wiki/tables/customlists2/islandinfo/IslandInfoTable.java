package org.idleon.wiki.tables.customlists2.islandinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class IslandInfoTable extends ArrayGameTable<IslandInfoTable.IslandInfo> {

    public IslandInfoTable(@NonNull Collection<IslandInfo> items) {
        super(items);
    }

    public record IslandInfo(
            @NonNull String name,
            int distance,
            int x2,
            int x3,
            int x4,
            long unlockDistance,
            @NonNull List<Integer> x6,
            @NonNull List<Integer> x7,
            int captainExperience
    ) {}

}
