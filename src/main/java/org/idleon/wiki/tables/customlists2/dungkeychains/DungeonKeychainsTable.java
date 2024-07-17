package org.idleon.wiki.tables.customlists2.dungkeychains;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class DungeonKeychainsTable extends ArrayGameTable<DungeonKeychainsTable.DungeonKeychain> {

    public DungeonKeychainsTable(@NonNull Collection<DungeonKeychain> items) {
        super(items);
    }

    public record DungeonKeychain(
        @NonNull String id,
        @NonNull String description,
        List<Double> tiers
    ) {}

}
