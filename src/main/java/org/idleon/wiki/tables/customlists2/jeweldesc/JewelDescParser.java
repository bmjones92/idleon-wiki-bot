package org.idleon.wiki.tables.customlists2.jeweldesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.ItemQuantityPair;
import org.idleon.wiki.tables.customlists2.jeweldesc.JewelDescTable.JewelDesc;

import java.util.ArrayList;
import java.util.List;

public class JewelDescParser extends DataTableParser<List<List<String>>, JewelDescTable> {

    public JewelDescParser() {
        super("scripts.CustomLists2", "JewelDesc");
    }

    @Override
    protected JewelDescTable parseData(@NonNull List<List<String>> input) {
        return new JewelDescTable(input.stream().map(this::parseJewelDescription).toList());
    }

    private JewelDesc parseJewelDescription(@NonNull List<String> jewel) {
        final var x = Integer.parseInt(jewel.get(0));
        final var y = Integer.parseInt(jewel.get(1));
        final var x2 = Integer.parseInt(jewel.get(2));
        final var description = TextTransformers.SPACES.transform(jewel.get(3));
        final var shopDescription = TextTransformers.SPACES.transform(jewel.get(4));
        final var cost = parseCost(jewel);
        final var name = TextTransformers.SPACES.transform(jewel.get(11));
        final var magnitude = Double.parseDouble(jewel.get(12));
        return new JewelDesc(x, y, x2, description, shopDescription, cost, name, magnitude);
    }

    private List<ItemQuantityPair> parseCost(@NonNull List<String> jewel) {
        final var cost = new ArrayList<ItemQuantityPair>();
        for (var i = 0; i < 3; i++) {
            final var item = jewel.get((i * 2) + 5);
            final var quantity = Integer.parseInt(jewel.get((i * 2) + 6));
            cost.add(new ItemQuantityPair(item, quantity));
        }
        return cost;
    }

}
