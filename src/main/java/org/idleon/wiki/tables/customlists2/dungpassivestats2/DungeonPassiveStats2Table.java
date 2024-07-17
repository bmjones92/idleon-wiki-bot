package org.idleon.wiki.tables.customlists2.dungpassivestats2;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.LavaMathFunc;

import java.util.Collection;

public class DungeonPassiveStats2Table extends ArrayGameTable<DungeonPassiveStats2Table.DungeonStat2> {

    public DungeonPassiveStats2Table(@NonNull Collection<DungeonStat2> items) {
        super(items);
    }

    public record DungeonStat2(
            @NonNull String name,
            @NonNull LavaMathFunc func,
            @NonNull String x4,
            @NonNull String bonus
    ) {}

}
