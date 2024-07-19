package org.idleon.wiki.tables.customlists2.islandplatforms;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class IslandPlatformsInfoTable extends ArrayGameTable<IslandPlatformsInfoTable.IslandPlatformsInfo> {

    public IslandPlatformsInfoTable(@NonNull Collection<IslandPlatformsInfo> items) {
        super(items);
    }

    public record IslandPlatformsInfo(
            @NonNull List<Integer> x0,
            @NonNull List<Integer> x1,
            @NonNull List<Integer> x2,
            @NonNull List<Integer> x3,
            @NonNull List<Integer> x4,
            @NonNull List<Integer> x5,
            @NonNull List<Integer> x6,
            @NonNull List<Integer> x7
    ) {}

}
