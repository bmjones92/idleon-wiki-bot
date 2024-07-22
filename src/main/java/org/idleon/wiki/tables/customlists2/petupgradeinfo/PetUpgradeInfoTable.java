package org.idleon.wiki.tables.customlists2.petupgradeinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class PetUpgradeInfoTable extends ArrayGameTable<PetUpgradeInfoTable.BreedingUpgrade> {

    public PetUpgradeInfoTable(@NonNull Collection<BreedingUpgrade> items) {
        super(items);
    }

    public record BreedingUpgrade(
            @NonNull String name,
            @Nullable Integer mealId,
            int x4,
            double x5,
            int x6,
            double x7,
            int maxLevel,
            @NonNull String description,
            @NonNull String bonusText,
            double bonusPerLevel
    ) {}

}
