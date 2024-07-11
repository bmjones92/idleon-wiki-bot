package org.idleon.wiki.tables.customlists.mapdetails;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.mapdetails.MapDetailsTable.MapDetails;

import java.util.List;

public class MapDetailsParser extends DataTableParser<List<List<List<Integer>>>, MapDetailsTable> {

    public MapDetailsParser() {
        super("scripts.CustomLists", "MapDetails");
    }

    @Override
    protected MapDetailsTable parseData(@NonNull List<List<List<Integer>>> input) {
        return new MapDetailsTable(input.stream().map(this::parseMap).toList());
    }

    private MapDetails parseMap(@NonNull List<List<Integer>> map) {
        final var x0 = map.get(0);
        final var x1 = map.get(1);
        final var x2 = map.get(2);
        return new MapDetails(x0, x1, x2);
    }

}
