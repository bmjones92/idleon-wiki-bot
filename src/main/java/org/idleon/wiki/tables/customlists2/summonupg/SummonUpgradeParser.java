package org.idleon.wiki.tables.customlists2.summonupg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.Position;
import org.idleon.wiki.tables.customlists2.summonupg.SummonUpgradeTable.SummonUpgrade;

import java.util.List;

public class SummonUpgradeParser extends DataTableParser<List<List<String>>, SummonUpgradeTable> {

    public SummonUpgradeParser() {
        super("scripts.CustomLists2", "SummonUPG");
    }

    @Override
    protected SummonUpgradeTable parseData(@NonNull List<List<String>> input) {
        return new SummonUpgradeTable(input.stream().map(this::parseUpgrade).toList());
    }

    private SummonUpgrade parseUpgrade(@NonNull List<String> input) {
        final var position = parsePosition(input);
        final var color = Integer.parseInt(input.get(2));
        final var name = TextTransformers.SPACES.transform(input.get(3));
        final var x4 = Integer.parseInt(input.get(4));
        final var x5 = Double.parseDouble(input.get(5));
        final var x6 = Integer.parseInt(input.get(6));
        final var x7 = Integer.parseInt(input.get(7));
        final var maxLevel = Integer.parseInt(input.get(8));
        final var x9 = Integer.parseInt(input.get(9));
        final var description = TextTransformers.SPACES.transform(input.get(11));
        return new SummonUpgrade(position, color, name, x4, x5, x6, x7, maxLevel, x9, description);
    }

    private Position parsePosition(@NonNull List<String> input) {
        final var x = Integer.parseInt(input.get(0));
        final var y = Integer.parseInt(input.get(1));
        return new Position(x, y);
    }

}
