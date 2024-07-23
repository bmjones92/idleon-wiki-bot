package org.idleon.wiki.tables.customlists2.territoryinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class TerritoryInfoTable extends ArrayGameTable<TerritoryInfoTable.TerritoryBattle> {

    public TerritoryInfoTable(@NonNull Collection<TerritoryBattle> items) {
        super(items);
    }

    public record TerritoryBattle(
            @NonNull String x0_background,
            int x1,
            int x2,
            int x3,
            @NonNull String x4_name,
            @NonNull List<TerritoryEnemy> enemies
    ) {}

    public record TerritoryEnemy(
            @NonNull String name,
            long hitpoints,
            int x2,
            int x3
    ) {}

}
