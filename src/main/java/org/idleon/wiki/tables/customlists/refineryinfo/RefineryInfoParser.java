package org.idleon.wiki.tables.customlists.refineryinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.refineryinfo.RefineryInfoTable.RefineryInfo;
import org.idleon.wiki.util.ItemQuantityPair;

import java.util.ArrayList;
import java.util.List;

public class RefineryInfoParser extends DataTableParser<List<List<String>>, RefineryInfoTable> {

    private static final int MAX_INGREDIENTS = 6;

    public RefineryInfoParser() {
        super("scripts.CustomLists", "RefineryInfo");
    }

    @Override
    protected RefineryInfoTable parseData(@NonNull List<List<String>> input) {
        return new RefineryInfoTable(input.stream().map(this::parseRefinery).toList());
    }

    private RefineryInfo parseRefinery(@NonNull List<String> refinery) {
        final var ingredients = new ArrayList<ItemQuantityPair>(6);
        for (var i = 0; i < MAX_INGREDIENTS; i++) {
            final var ingredient = parseIngredient(refinery, i);
            if (ingredient == null) {
                break;
            }
            ingredients.add(ingredient);
        }
        final var output = refinery.getLast();
        return new RefineryInfo(output, ingredients);
    }

    private ItemQuantityPair parseIngredient(@NonNull List<String> refinery, int index) {
        final var item = refinery.get(index);
        if (item.equals("Blank")) {
            return null;
        }
        final var quantity = Integer.parseInt(refinery.get(index + MAX_INGREDIENTS));
        return new ItemQuantityPair(item, quantity);
    }

}
