package org.idleon.wiki.tables.customlists2.islandinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.islandinfo.IslandInfoTable.IslandInfo;

import java.util.List;
import java.util.stream.Stream;

public class IslandInfoParser extends DataTableParser<List<List<String>>, IslandInfoTable> {

    public IslandInfoParser() {
        super("scripts.CustomLists2", "IslandInfo");
    }

    @Override
    protected IslandInfoTable parseData(@NonNull List<List<String>> input) {
        return new IslandInfoTable(input.stream().map(this::parseIslandInfo).toList());
    }

    private IslandInfo parseIslandInfo(@NonNull List<String> island) {
        final var x0 = TextTransformers.SPACES.transform(island.get(0));
        final var distance = Integer.parseInt(island.get(1));
        final var x2 = Integer.parseInt(island.get(2));
        final var x3 = Integer.parseInt(island.get(3));
        final var x4 = Integer.parseInt(island.get(4));
        final var unlockDistance = Long.parseLong(island.get(5));
        final var x6 = parseList(island.get(6), "\\.");
        final var x7 = parseList(island.get(7), ",");
        final var captainExperience = Integer.parseInt(island.get(8));
        return new IslandInfo(x0, distance, x2, x3, x4, unlockDistance,x6, x7, captainExperience);
    }

    private List<Integer> parseList(@NonNull String line, @NonNull String delimiter) {
        return Stream.of(line.split(delimiter)).map(Integer::parseInt).toList();
    }

}
