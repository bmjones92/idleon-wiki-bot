package org.idleon.wiki.tables.customlists2.boatsinharbor;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.common.Position;

import java.util.List;

public class BoatsInHarborParser extends DataTableParser<List<List<Integer>>, BoatsInHarborTable> {

    public BoatsInHarborParser() {
        super("scripts.CustomLists2", "BoatsInHarbor");
    }

    @Override
    protected BoatsInHarborTable parseData(@NonNull List<List<Integer>> input) {
        return new BoatsInHarborTable(input.stream().map(this::parseCoordinate).toList());
    }

    private Position parseCoordinate(@NonNull List<Integer> parser) {
        return new Position(parser.get(0), parser.get(1));
    }

}
