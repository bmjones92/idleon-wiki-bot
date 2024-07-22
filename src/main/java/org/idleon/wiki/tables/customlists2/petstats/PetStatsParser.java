package org.idleon.wiki.tables.customlists2.petstats;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.petstats.PetStatsTable.PetStats;

import java.util.List;
import java.util.Objects;

public class PetStatsParser extends DataTableParser<List<List<List<String>>>, PetStatsTable> {

    public PetStatsParser() {
        super("scripts.CustomLists2", "PetStats");
    }

    @Override
    protected PetStatsTable parseData(@NonNull List<List<List<String>>> input) {
        return new PetStatsTable(input.stream().map(this::parseWorld).filter(world -> !world.isEmpty()).toList());
    }

    private List<PetStats> parseWorld(@NonNull List<List<String>> input) {
        return input.stream().map(this::parsePetStats).filter(Objects::nonNull).toList();
    }

    private PetStats parsePetStats(@NonNull List<String> input) {
        if (input.size() != 6) {
            return null;
        }

        final var mobName = input.get(0);
        if (mobName.equals("_")) {
            return null;
        }

        final var x1 = input.get(1).equals("_") ? null : Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var x3 = Integer.parseInt(input.get(3));
        final var x4 = Integer.parseInt(input.get(4));
        final var x5 = Integer.parseInt(input.get(5));
        return new PetStats(mobName, x1, x2, x3, x4, x5);
    }

}
