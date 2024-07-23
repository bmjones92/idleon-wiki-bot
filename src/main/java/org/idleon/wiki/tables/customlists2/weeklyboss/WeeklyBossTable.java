package org.idleon.wiki.tables.customlists2.weeklyboss;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class WeeklyBossTable extends ArrayGameTable<WeeklyBossTable.WeeklyBoss> {

    public WeeklyBossTable(@NonNull Collection<WeeklyBoss> items) {
        super(items);
    }

    public record WeeklyBoss(
            @NonNull String name,
            int x1,
            int x2,
            int x3,
            int x4,
            double x5,
            int x6,
            int x7,
            int x8
    ) {}

}
