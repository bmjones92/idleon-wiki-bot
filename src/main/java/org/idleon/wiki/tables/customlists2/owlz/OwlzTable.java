package org.idleon.wiki.tables.customlists2.owlz;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record OwlzTable(
        @NonNull FeatherActivity featherActivity,
        @NonNull FishActivity fishActivity
) implements GameTable {

    public record FeatherActivity(
            @NonNull List<Upgrade> upgrades,
            @NonNull List<String> bonusLabels
    ) {}

    public record FishActivity(
            @NonNull List<Upgrade> pondUpgrades,
            @NonNull List<Upgrade> tarPoolUpgrades,
            @NonNull List<String> bonusLabels
    ) {}

    /**
     * Describes an upgrade
     * @param name
     * @param x1
     * @param x2
     * @param x3
     * @param description
     * @param magnitude
     */
    public record Upgrade(
            @NonNull String name,
            long x1,
            double x2,
            @Nullable Long x3,
            @Nullable String description,
            int magnitude
    ) {}

}
