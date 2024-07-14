package org.idleon.wiki.tables.customlists2.achballzbonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class AchBallsBonusesTable extends ArrayGameTable<AchBallsBonusesTable.AchBallsBonus> {

    public AchBallsBonusesTable(@NonNull Collection<AchBallsBonus> items) {
        super(items);
    }

    public record AchBallsBonus(
            int x0,
            int x1
    ) {}

}
