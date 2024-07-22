package org.idleon.wiki.tables.customlists2.playercapacities;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

/**
 * Describes the "PlayerCapacities" table.
 * @param inventory The list of inventory capacity items.
 * @param storage The list of storage chest items.
 * @param tiers The stack sizes for each capacity tier.
 * @param types The list of capacity items for each item type.
 */
public record PlayerCapacitiesTable(
        @NonNull List<CapacityItem> inventory,
        @NonNull List<CapacityItem> storage,
        @NonNull List<Integer> tiers,
        @NonNull List<CapacityGroup> types
) implements GameTable {

    public record CapacityItem(
            int x0,
            int x1,
            @NonNull String name
    ) {}

    public record CapacityGroup(
        @NonNull String name,
        @NonNull List<String> items
    ) {}

}
