package org.idleon.wiki.tables.customlists2.weeklyshop;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record WeeklyShopTable(
        @NonNull List<WeeklyShopItem> themes,
        @NonNull List<WeeklyShopItem> items
) implements GameTable {

    public record WeeklyShopItem(
            @NonNull String name,
            int cost,
            @NonNull String reward,
            @NonNull String description,
            boolean x4
    ) {}

}
