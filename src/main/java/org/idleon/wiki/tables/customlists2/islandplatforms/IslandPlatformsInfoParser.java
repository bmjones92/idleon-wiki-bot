package org.idleon.wiki.tables.customlists2.islandplatforms;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.islandplatforms.IslandPlatformsInfoTable.IslandPlatformsInfo;

import java.util.List;
import java.util.stream.Stream;

public class IslandPlatformsInfoParser extends DataTableParser<List<List<String>>, IslandPlatformsInfoTable> {

    public IslandPlatformsInfoParser() {
        super("scripts.CustomLists2", "IslandPlatformsInfo");
    }

    @Override
    protected IslandPlatformsInfoTable parseData(@NonNull List<List<String>> input) {
        return new IslandPlatformsInfoTable(input.stream().map(this::parseIsland).toList());
    }

    private IslandPlatformsInfo parseIsland(@NonNull List<String> island) {
        final var x0 = parseList(island.get(0), ",");
        final var x1 = parseList(island.get(1), ";");
        final var x2 = parseList(island.get(2), ";");
        final var x3 = parseList(island.get(3), ";");
        final var x4 = parseList(island.get(4), ",");
        final var x5 = parseList(island.get(5), ",");
        final var x6 = parseList(island.get(6), ",");
        final var x7 = parseList(island.get(7), ",");
        return new IslandPlatformsInfo(x0, x1, x2, x3, x4, x5, x6, x7);
    }

    private List<Integer> parseList(@NonNull String line, @NonNull String regex) {
        return Stream.of(line.split(regex)).map(Integer::parseInt).toList();
    }

}
