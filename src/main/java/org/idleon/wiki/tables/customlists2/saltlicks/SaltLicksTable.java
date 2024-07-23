package org.idleon.wiki.tables.customlists2.saltlicks;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SaltLicksTable extends ArrayGameTable<SaltLicksTable.SaltLickBonus> {

    public SaltLicksTable(@NonNull Collection<SaltLickBonus> items) {
        super(items);
    }

    /**
     * Describes a salt lick bonus.
     * @param material
     * @param description
     * @param maxLevel
     * @param baseCost
     * @param costScalar
     * @param bonusPerLevel
     */
    public record SaltLickBonus(
            @NonNull String material,
            @NonNull String description,
            int maxLevel,
            int baseCost,
            double costScalar,
            double bonusPerLevel
    ) {

        public double getBonusForLevel(int level) {
            return bonusPerLevel * level;
        }

        public double getMaxBonus() {
            return getBonusForLevel(maxLevel);
        }

        public int getCostForLevel(int level) {
            return (int) (baseCost * Math.pow(costScalar, level));
        }

    }

}
