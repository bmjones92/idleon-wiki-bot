package org.idleon.wiki.tables.customlists2.summonunits;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.summonunits.SummonUnitsTable.SummonUnit;

import java.util.List;

public class SummonUnitsParser extends DataTableParser<List<List<String>>, SummonUnitsTable> {

    public SummonUnitsParser() {
        super("scripts.CustomLists2", "SummonUnits");
    }

    @Override
    protected SummonUnitsTable parseData(@NonNull List<List<String>> input) {
        return new SummonUnitsTable(input.stream().map(this::parseUnit).toList());
    }

    private SummonUnit parseUnit(@NonNull List<String> input) {
        final var height = Integer.parseInt(input.get(0));
        final var speed = Double.parseDouble(input.get(1));
        final var width = Integer.parseInt(input.get(2));
        final var font = Integer.parseInt(input.get(3));
        final var x4 = Integer.parseInt(input.get(4));
        final var x5 = Integer.parseInt(input.get(5));
        final var cost = Integer.parseInt(input.get(6));
        final var hp = Integer.parseInt(input.get(7));
        final var damage = Double.parseDouble(input.get(8));

        final var size = new SummonUnitsTable.Size(width, height);
        return new SummonUnit(size, speed, font, x4, x5, cost, hp, damage);
    }

}
