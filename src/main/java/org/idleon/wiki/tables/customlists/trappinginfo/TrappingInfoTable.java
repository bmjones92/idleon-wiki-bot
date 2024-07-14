package org.idleon.wiki.tables.customlists.trappinginfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class TrappingInfoTable extends ArrayGameTable<TrappingInfoTable.TrappingInfo> {

    public TrappingInfoTable(@NonNull Collection<TrappingInfo> items) {
        super(items);
    }

    public record TrappingInfo(
            int x0,
            int x1,
            @NonNull String item,
            int x3,
            int bonusEfficiency,
            int experience,
            double shinyChance
    ) {}

}
