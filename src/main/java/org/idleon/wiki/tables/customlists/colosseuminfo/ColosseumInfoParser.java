package org.idleon.wiki.tables.customlists.colosseuminfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.colosseuminfo.ColosseumInfoTable.ColosseumInfo;

import java.util.List;

public class ColosseumInfoParser extends DataTableParser<List<List<Integer>>, ColosseumInfoTable> {

    public ColosseumInfoParser() {
        super("scripts.CustomLists", "ColosseumInfo");
    }

    @Override
    protected ColosseumInfoTable parseData(@NonNull List<List<Integer>> input) {
        return new ColosseumInfoTable(input.stream().map(this::parseColosseumInfo).toList());
    }

    private ColosseumInfo parseColosseumInfo(@NonNull List<Integer> input) {
        final var x0 = input.get(0);
        final var x1 = input.get(1);
        final var x2 = input.get(2);
        final var ticketCost = input.get(3);
        final var x4 = input.get(4);
        final var x5 = input.get(5);
        final var bronzeChestThreshold = input.get(6);
        final var silverChestThreshold = input.get(7);
        final var goldChestThreshold = input.get(8);
        final var x9 = input.get(9);
        final var x10 = input.get(10);
        final var x11 = input.get(11);
        final var x12 = input.get(12);
        final var x13 = input.get(13);
        return new ColosseumInfo(
                x0,
                x1,
                x2,
                ticketCost,
                x4,
                x5,
                bronzeChestThreshold,
                silverChestThreshold,
                goldChestThreshold,
                x9,
                x10,
                x11,
                x12,
                x13);
    }

}
