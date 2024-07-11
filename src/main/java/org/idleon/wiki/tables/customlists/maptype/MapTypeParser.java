package org.idleon.wiki.tables.customlists.maptype;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class MapTypeParser extends DataTableParser<List<List<Integer>>, MapTypeTable> {

    public MapTypeParser() {
        super("scripts.CustomLists", "MapType");
    }

    @Override
    protected MapTypeTable parseData(@NonNull List<List<Integer>> input) {
        final var towns = input.get(0);
        final var nonTowns = input.get(1);
        return new MapTypeTable(towns, nonTowns);
    }
}
