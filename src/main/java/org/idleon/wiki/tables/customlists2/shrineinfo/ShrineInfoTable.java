package org.idleon.wiki.tables.customlists2.shrineinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class ShrineInfoTable extends ArrayGameTable<ShrineInfoTable.ShrineInfo> {

    public ShrineInfoTable(@NonNull Collection<ShrineInfo> items) {
        super(items);
    }

    public record ShrineInfo(
        @NonNull String name,
        @NonNull String description,
        int baseBonus,
        double bonusPerLevel,
        int x4
    ) {}

}
