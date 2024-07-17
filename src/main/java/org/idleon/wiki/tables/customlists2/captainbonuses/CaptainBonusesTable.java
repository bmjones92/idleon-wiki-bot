package org.idleon.wiki.tables.customlists2.captainbonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class CaptainBonusesTable extends ArrayGameTable<CaptainBonusesTable.CaptainBonus> {

    public CaptainBonusesTable(@NonNull Collection<CaptainBonus> items) {
        super(items);
    }

    public record CaptainBonus(
            int x0,
            int x1,
            int x2,
            @NonNull String description
    ) {}

}
