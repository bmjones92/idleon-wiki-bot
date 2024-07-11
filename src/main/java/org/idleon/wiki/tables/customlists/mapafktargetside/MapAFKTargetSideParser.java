package org.idleon.wiki.tables.customlists.mapafktargetside;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class MapAFKTargetSideParser extends DataTableParser<List<List<String>>, MapAFKTargetSideTable> {

    public MapAFKTargetSideParser() {
        super("scripts.CustomLists", "MapAFKtargetSide");
    }

    @Override
    protected MapAFKTargetSideTable parseData(@NonNull List<List<String>> input) {
        return new MapAFKTargetSideTable(input.stream().map(List::getFirst).map(this::parseEntry).toList());
    }

    private String parseEntry(@NonNull String entry) {
        if (entry.equals("_") || entry.equals("Z")) {
            return null;
        }
        return entry;
    }

}
