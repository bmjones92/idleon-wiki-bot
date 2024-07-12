package org.idleon.wiki.tables.customlists.mtxinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record MTXInfoTable(
        @NonNull List<List<MTXInfo>> cosmetics,
        @NonNull List<List<MTXInfo>> usables,
        @NonNull List<List<MTXInfo>> bonuses
) implements GameTable {

    public record MTXInfo(
        @NonNull String icon,
        @NonNull String title,
        @NonNull String description,
        int cost,
        int x4,
        int maxPurchases,
        boolean givesItem,
        int costIncrease
    ) {}

}