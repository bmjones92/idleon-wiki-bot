package org.idleon.wiki.tables.customlists2.seedinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SeedInfoTable extends ArrayGameTable<SeedInfoTable.SeedInfo> {

    public SeedInfoTable(@NonNull Collection<SeedInfo> items) {
        super(items);
    }

    public record SeedInfo(
            @NonNull String name,
            int id,
            int x2,
            int x3,
            int levelRequirement,
            double evolutionChance,
            double x6
    ) {}

}
