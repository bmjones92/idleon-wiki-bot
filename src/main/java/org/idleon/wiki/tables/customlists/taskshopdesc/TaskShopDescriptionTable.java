package org.idleon.wiki.tables.customlists.taskshopdesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class TaskShopDescriptionTable extends ArrayGameTable<List<TaskShopDescriptionTable.MeritShopItem>> {

    public TaskShopDescriptionTable(@NonNull Collection<List<MeritShopItem>> items) {
        super(items);
    }

    public record MeritShopItem(
            @NonNull String description,
            @Nullable MeritTask task,
            int numTiers,
            int costPerTier,
            @Nullable List<String> flavors,
            @NonNull String icon,
            double x11
    ) {}

    public record MeritTask(
            int minLevel,
            int maxLevel
    ) {}

}
