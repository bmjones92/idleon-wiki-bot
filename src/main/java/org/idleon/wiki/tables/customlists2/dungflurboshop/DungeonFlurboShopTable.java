package org.idleon.wiki.tables.customlists2.dungflurboshop;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class DungeonFlurboShopTable extends ArrayGameTable<DungeonFlurboShopTable.FlurboShopItem> {

    public DungeonFlurboShopTable(@NonNull Collection<FlurboShopItem> items) {
        super(items);
    }

    public record FlurboShopItem(
            @NonNull String id,
            int cost,
            boolean requiresPreviousUnlock,
            @NonNull String name,
            @NonNull String description
    ) {}

}
