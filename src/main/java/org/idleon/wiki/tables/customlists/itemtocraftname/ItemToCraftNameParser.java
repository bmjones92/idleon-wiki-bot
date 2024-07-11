package org.idleon.wiki.tables.customlists.itemtocraftname;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ItemToCraftNameParser extends DataTableParser<List<List<String>>, ItemToCraftNameTable> {

    public ItemToCraftNameParser() {
        super("scripts.CustomLists", "ItemToCraftNAME");
    }

    @Override
    protected ItemToCraftNameTable parseData(@NonNull List<List<String>> input) {
        return new ItemToCraftNameTable(input);
    }

}
