package org.idleon.wiki.tables.customlists2.mealinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class MealInfoTable extends ArrayGameTable<MealInfoTable.MealInfo> {

    public MealInfoTable(@NonNull Collection<MealInfo> items) {
        super(items);
    }

    public record MealInfo(
            @NonNull String name,
            long work,
            int x2,
            @NonNull String description,
            @NonNull String flavorText,
            @NonNull String bonus
    ) {}

}
