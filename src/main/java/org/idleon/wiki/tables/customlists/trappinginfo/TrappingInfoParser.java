package org.idleon.wiki.tables.customlists.trappinginfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.trappinginfo.TrappingInfoTable.TrappingInfo;

import java.util.List;

public class TrappingInfoParser extends DataTableParser<List<List<String>>, TrappingInfoTable> {

    public TrappingInfoParser() {
        super("scripts.CustomLists", "TrappingInfo");
    }

    @Override
    protected TrappingInfoTable parseData(@NonNull List<List<String>> input) {
        return new TrappingInfoTable(input.stream().map(this::parseCritter).toList());
    }

    private TrappingInfo parseCritter(@NonNull List<String> critter) {
        final var x0 = Integer.parseInt(critter.get(0));
        final var x1 = Integer.parseInt(critter.get(1));
        final var item = critter.get(2);
        final var x3 = Integer.parseInt(critter.get(3));
        final var bonusEfficiency = Integer.parseInt(critter.get(4));
        final var experience = Integer.parseInt(critter.get(5));
        final var shinyChance = Double.parseDouble(critter.get(6));
        return new TrappingInfo(x0, x1, item, x3, bonusEfficiency, experience, shinyChance);
    }

}
