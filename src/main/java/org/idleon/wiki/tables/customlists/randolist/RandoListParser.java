package org.idleon.wiki.tables.customlists.randolist;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class RandoListParser extends DataTableParser<List<List<String>>, RandoListTable> {

    public RandoListParser() {
        super("scripts.CustomLists", "RANDOlist");
    }

    @Override
    protected RandoListTable parseData(@NonNull List<List<String>> input) {
        return null;
    }

}
