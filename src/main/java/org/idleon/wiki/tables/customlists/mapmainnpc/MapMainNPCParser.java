package org.idleon.wiki.tables.customlists.mapmainnpc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class MapMainNPCParser extends DataTableParser<List<String>, MapMainNPCTable> {

    public MapMainNPCParser() {
        super("scripts.CustomLists", "MapMainNPC");
    }

    @Override
    protected MapMainNPCTable parseData(@NonNull List<String> input) {
        return new MapMainNPCTable(input);
    }

}
