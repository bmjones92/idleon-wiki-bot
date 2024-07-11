package org.idleon.wiki.tables.customlists.mapafktarget;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class MapAFKTargetParser extends DataTableParser<List<String>, MapAFKTargetTable> {

    public MapAFKTargetParser() {
        super("scripts.CustomLists", "MapAFKtarget");
    }

    @Override
    protected MapAFKTargetTable parseData(@NonNull List<String> input) {
        return new MapAFKTargetTable(input);
    }

}
