package org.idleon.wiki.tables.customlists2.achballzbonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

import static org.idleon.wiki.tables.customlists2.achballzbonuses.AchBallsBonusesTable.AchBallsBonus;

public class AchBallsBonusesParser extends DataTableParser<List<List<Integer>>, AchBallsBonusesTable> {

    public AchBallsBonusesParser() {
        super("scripts.CustomLists2", "AchBallzBonuses");
    }

    @Override
    protected AchBallsBonusesTable parseData(@NonNull List<List<Integer>> input) {
        return new AchBallsBonusesTable(input.stream().map(this::parseBonus).toList());
    }

    private AchBallsBonus parseBonus(@NonNull List<Integer> bonus) {
        final var x0 = bonus.get(0);
        final var x1 = bonus.get(1);
        return new AchBallsBonus(x0, x1);
    }

}
