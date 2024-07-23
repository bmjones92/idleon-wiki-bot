package org.idleon.wiki.tables.customlists2.summonupg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.Position;

import java.util.Collection;

public class SummonUpgradeTable extends ArrayGameTable<SummonUpgradeTable.SummonUpgrade> {

    public SummonUpgradeTable(@NonNull Collection<SummonUpgrade> items) {
        super(items);
    }

    public record SummonUpgrade(
            @NonNull Position position,
            int color,
            @NonNull String name,
            int x4,
            double x5,
            int x6,
            int x7,
            int maxLevel,
            int x9,
            @NonNull String description
    ) {}

}
