package org.idleon.wiki.tables.customlists2.atominfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class AtomInfoTable extends ArrayGameTable<AtomInfoTable.AtomInfo> {

    public AtomInfoTable(@NonNull Collection<AtomInfo> items) {
        super(items);
    }

    public record AtomInfo(
            @NonNull String name,
            int growthFactor,
            double baseExponent,
            int baseCost,
            int bonusPerLevel,
            @NonNull String description
    ) {}

}
