package org.idleon.wiki.tables.customlists2.ninjainfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;
import org.idleon.wiki.tables.common.LabMainBonus;

import java.util.List;

public record NinjaInfoTable(
        @NonNull List<FloorInfo> floors,
        @NonNull List<LabMainBonus> labNodes,
        @NonNull List<BeanstalkFood> beanstalkFoods,
        @NonNull List<String> deathNoteBossMobs,
        @NonNull List<String> cropDepotBonuses,
        @NonNull List<String> tomeBonuses,
        @NonNull List<Integer> x4,
        @NonNull List<Integer> x5,
        @NonNull List<Integer> x24,
        @NonNull List<Integer> x32
) implements GameTable {

    public record FloorInfo(
            long doorDurability, double baseStealth, int baseJadeGain, int baseExperience,
            @NonNull List<NinjaDropTableEntry> dropTable, int x0, int x1, int x2, int x6, int x7, int x8
    ) {}

    public record NinjaDropTableEntry(
        @NonNull String item,
        double chance
    ) {}

    public record BeanstalkFood(
            @NonNull String item,
            int x,
            int y
    ) {}

}
