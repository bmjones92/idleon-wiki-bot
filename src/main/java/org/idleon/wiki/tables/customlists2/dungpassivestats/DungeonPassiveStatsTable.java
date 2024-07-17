package org.idleon.wiki.tables.customlists2.dungpassivestats;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.LavaMathFunc;

import java.util.Collection;

public class DungeonPassiveStatsTable extends ArrayGameTable<DungeonPassiveStatsTable.DungeonStat> {

    public DungeonPassiveStatsTable(@NonNull Collection<DungeonStat> items) {
        super(items);
    }

    public record DungeonStat(
            @NonNull String name,
            @NonNull LavaMathFunc func,
            @NonNull String x4,
            @NonNull String bonus
    ) {}

}
