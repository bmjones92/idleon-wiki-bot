package org.idleon.wiki.tables.customlists.shopqty;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ShopQuantityParser extends DataTableParser<List<List<String>>, ShopQuantityTable> {

    public ShopQuantityParser() {
        super("scripts.CustomLists", "ShopQTY");
    }

    @Override
    protected ShopQuantityTable parseData(@NonNull List<List<String>> input) {
        return new ShopQuantityTable(input.stream().map(this::parseShop).toList());
    }

    private List<Integer> parseShop(@NonNull List<String> shop) {
        return shop.stream().map(Integer::parseInt).toList();
    }

}
