package org.idleon.wiki.tables.customlists.shopnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ShopNamesParser extends DataTableParser<List<List<String>>, ShopNamesTable> {

    public ShopNamesParser() {
        super("scripts.CustomLists", "ShopNames");
    }

    @Override
    protected ShopNamesTable parseData(@NonNull List<List<String>> input) {
        return new ShopNamesTable(input);
    }

}
