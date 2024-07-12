package org.idleon.wiki.tables.customlists.obolrarities;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ObolRaritiesParser extends DataTableParser<List<String>, ObolRaritiesTable> {

    public ObolRaritiesParser() {
        super("scripts.CustomLists", "ObolRarities");
    }

    @Override
    protected ObolRaritiesTable parseData(@NonNull List<String> input) {
        return new ObolRaritiesTable(input);
    }

}
