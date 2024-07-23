package org.idleon.wiki.tables.customlists2.sailingmappaths;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.common.Position;

import java.util.List;

public class SailingMapPathsParser extends DataTableParser<List<List<List<Integer>>>, SailingMapPathsTable> {

    public SailingMapPathsParser() {
        super("scripts.CustomLists2", "SailingMapPaths");
    }

    @Override
    protected SailingMapPathsTable parseData(@NonNull List<List<List<Integer>>> input) {
        return new SailingMapPathsTable(input.stream().map(this::parsePath).toList());
    }

    private List<Position> parsePath(@NonNull List<List<Integer>> input) {
        return input.stream()
                .map(coordinate -> new Position(coordinate.get(0), coordinate.get(1)))
                .toList();
    }

}
