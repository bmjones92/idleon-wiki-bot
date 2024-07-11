package org.idleon.wiki.tables.customlists.mapname;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class MapNameParser extends DataTableParser<List<String>, MapNameTable> {

    public MapNameParser() {
        super("scripts.CustomLists", "MapName");
    }

    @Override
    protected MapNameTable parseData(@NonNull List<String> input) {
        return new MapNameTable(input);
    }

}
