package org.idleon.wiki.tables.customlists2.captainbonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.captainbonuses.CaptainBonusesTable.CaptainBonus;

import java.util.List;

public class CaptainBonusesParser extends DataTableParser<List<List<String>>, CaptainBonusesTable> {

    public CaptainBonusesParser() {
        super("scripts.CustomLists2", "CaptainBonuses");
    }

    @Override
    protected CaptainBonusesTable parseData(@NonNull List<List<String>> input) {
        return new CaptainBonusesTable(input.stream().map(this::parseBonus).toList());
    }

    private CaptainBonus parseBonus(@NonNull List<String> bonus) {
        final var x0 = Integer.parseInt(bonus.get(0));
        final var x1 = Integer.parseInt(bonus.get(1));
        final var x2 = Integer.parseInt(bonus.get(2));
        final var description = TextTransformers.SPACES.transform(bonus.get(3));
        return new CaptainBonus(x0, x1, x2, description);
    }

}
