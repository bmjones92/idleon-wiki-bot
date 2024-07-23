package org.idleon.wiki.tables.customlists2.towerinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.ItemQuantityPair;

import java.util.Collection;
import java.util.List;

public class TowerInfoTable extends ArrayGameTable<TowerInfoTable.TowerInfo> {

    public TowerInfoTable(@NonNull Collection<TowerInfo> items) {
        super(items);
    }

    public record TowerInfo(
            @NonNull String name,
            @NonNull String description,
            double bonusPerLevel,
            double x3,
            @NonNull List<ItemQuantityPair> cost,
            int baseMax,
            double x9,
            int boostedMax
    ) {}

}
