package org.idleon.wiki.tables.customlists.worldservernames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class WorldServerNamesParser extends DataTableParser<List<String>, WorldServerNamesTable> {

    public WorldServerNamesParser() {
        super("scripts.CustomLists", "WorldServerNames");
    }

    @Override
    protected WorldServerNamesTable parseData(@NonNull List<String> input) {
        return new WorldServerNamesTable(input);
    }

}
