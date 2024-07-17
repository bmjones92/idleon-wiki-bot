package org.idleon.wiki.tables.customlists.itemtocraftcosttype;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.common.ItemQuantityPair;

import java.util.List;

public class ItemToCraftCostTypeParser extends DataTableParser<List<List<List<List<String>>>>, ItemToCraftCostTypeTable> {

    public ItemToCraftCostTypeParser() {
        super("scripts.CustomLists", "ItemToCraftCostTYPE");
    }

    @Override
    protected ItemToCraftCostTypeTable parseData(@NonNull List<List<List<List<String>>>> input) {
        return new ItemToCraftCostTypeTable(input.stream().map(this::parseAnvilTab).toList());
    }

    private List<List<ItemQuantityPair>> parseAnvilTab(@NonNull List<List<List<String>>> tab) {
        return tab.stream().map(this::parseIngredients).toList();
    }

    private List<ItemQuantityPair> parseIngredients(@NonNull List<List<String>> item) {
        return item.stream().map(this::parseIngredient).toList();
    }

    private ItemQuantityPair parseIngredient(@NonNull List<String> ingredient) {
        final var name = ingredient.get(0);
        final var quantity = Integer.parseInt(ingredient.get(1));
        return new ItemQuantityPair(name, quantity);
    }

}
