package org.idleon.wiki.tables.customlists.shoplocations;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ShopLocationsParser extends DataTableParser<List<Integer>, ShopLocationsTable> {

    public ShopLocationsParser() {
        super("scripts.CustomLists", "ShopLocations");
    }

    @Override
    protected ShopLocationsTable parseData(@NonNull List<Integer> input) {
        return new ShopLocationsTable(input);
    }

}
