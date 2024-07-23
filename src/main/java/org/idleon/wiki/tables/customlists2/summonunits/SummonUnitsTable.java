package org.idleon.wiki.tables.customlists2.summonunits;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SummonUnitsTable extends ArrayGameTable<SummonUnitsTable.SummonUnit> {

    public SummonUnitsTable(@NonNull Collection<SummonUnit> items) {
        super(items);
    }

    public record SummonUnit(
        @NonNull Size size,
        double speed,
        int font,
        int x4,
        int x5,
        int cost,
        int hitpoints,
        double damage
    ) {}

    public record Size(
            int width,
            int height
    ) {}

}
