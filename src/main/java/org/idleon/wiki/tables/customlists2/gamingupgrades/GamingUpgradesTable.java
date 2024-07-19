package org.idleon.wiki.tables.customlists2.gamingupgrades;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class GamingUpgradesTable extends ArrayGameTable<GamingUpgradesTable.GamingUpgrade> {

    public GamingUpgradesTable(@NonNull Collection<GamingUpgrade> items) {
        super(items);
    }

    public record GamingUpgrade(
            @NonNull String name,
            int x1,
            int x2,
            int x3,
            int x4,
            @NonNull String description
    ) {}

}
