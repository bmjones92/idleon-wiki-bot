package org.idleon.wiki.tables.customlists2.gamingupg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class GamingUpgTable extends ArrayGameTable<GamingUpgTable.GamingUpgrade> {

    public GamingUpgTable(@NonNull Collection<GamingUpgrade> items) {
        super(items);
    }

    public record GamingUpgrade(
        @NonNull String description,
        int x1,
        int x2,
        @NonNull String name
    ) {}

}
