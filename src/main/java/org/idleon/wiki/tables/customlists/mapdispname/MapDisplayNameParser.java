package org.idleon.wiki.tables.customlists.mapdispname;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class MapDisplayNameParser extends DataTableParser<List<String>, MapDisplayNameTable> {

    public MapDisplayNameParser() {
        super("scripts.CustomLists", "MapDispName");
    }

    @Override
    protected MapDisplayNameTable parseData(@NonNull List<String> input) {
        return new MapDisplayNameTable(input.stream().map(this::parseEntry).toList());
    }

    private String parseEntry(@NonNull String entry) {
        return entry.equals("Z") ? null : entry;
    }

}
