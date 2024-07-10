package org.idleon.wiki.tables.customlists.alchemydescription;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.alchemydescription.AlchemyDescriptionTable.AlchemyBubble;
import org.idleon.wiki.tables.customlists.alchemydescription.AlchemyDescriptionTable.AlchemyShopItem;
import org.idleon.wiki.tables.customlists.alchemydescription.AlchemyDescriptionTable.AlchemyVial;
import org.idleon.wiki.util.ItemQuantityPair;
import org.idleon.wiki.util.LavaMathFunc;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class AlchemyDescriptionParser extends DataTableParser<List<List<List<String>>>, AlchemyDescriptionTable> {

    public AlchemyDescriptionParser() {
        super("scripts.CustomLists", "AlchemyDescription");
    }

    @Override
    protected AlchemyDescriptionTable parseData(@NonNull List<List<List<String>>> input) {
        final var str = parseCauldron(input.get(0));
        final var agi = parseCauldron(input.get(1));
        final var wis = parseCauldron(input.get(2));
        final var luk = parseCauldron(input.get(3));
        final var vials = parseVials(input.get(4));
        final var shop = parseShopItems(input.get(5));
        return new AlchemyDescriptionTable(str, agi, wis, luk, vials, shop);
    }

    private List<AlchemyBubble> parseCauldron(@NonNull List<List<String>> cauldron) {
        return cauldron.stream().map(bubble -> {
           final var name = TextTransformers.TITLE.transform(bubble.get(0));
            final var func = LavaMathFunc.parse(bubble, 1);
            final var ingredients = parseItemQuantityPairs(bubble);
            final var description = TextTransformers.DESCRIPTION.transform(bubble.get(9));
            final var isEquippable = TextTransformers.parseBoolean(bubble.get(10));
            final var bonus = bubble.get(15);

            return new AlchemyBubble(name, checkNotNull(func), ingredients, description, isEquippable, bonus);
        }).toList();
    }

    private List<AlchemyVial> parseVials(@NonNull List<List<String>> vials) {
        return vials.stream().map(vial -> {
            final var name = TextTransformers.TITLE.transform(vial.get(0));
            final var func = LavaMathFunc.parse(vial, 1);
            final var ingredients = vial.subList(5, 9).stream().filter(ingredient -> !ingredient.equals("Blank")).toList();
            final var description = TextTransformers.DESCRIPTION.transform(vial.get(9));
            final var x10 = Integer.parseInt(vial.get(10));
            final var bonus = vial.get(11);

            return new AlchemyVial(name, checkNotNull(func), ingredients, description, x10, bonus);
        }).toList();
    }

    private List<AlchemyShopItem> parseShopItems(@NonNull List<List<String>> shop) {
        return shop.stream().map(item -> {
            final var name = TextTransformers.TITLE.transform(item.get(0));
            final var x1 = Integer.parseInt(item.get(1));
            final var x2 = Integer.parseInt(item.get(2));
            final var x3 = Integer.parseInt(item.get(3));
            final var x4 = Double.parseDouble(item.get(4));
            final var cost = item.subList(5, 9).stream().filter(costItem -> !costItem.equals("Blank")).toList();
            final var description = TextTransformers.DESCRIPTION.transform(item.get(9));
            final var x10 = Integer.parseInt(item.get(10));
            final var x11 = Integer.parseInt(item.get(11));
            final var x12 = Integer.parseInt(item.get(12));
            final var x13 = Integer.parseInt(item.get(13));
            final var x14 = Integer.parseInt(item.get(14));
            final var x15 = Integer.parseInt(item.get(15));
            final var x16 = Integer.parseInt(item.get(16));

            return new AlchemyShopItem(name, x1, x2, x3, x4, cost, description, x10, x11, x12, x13, x14, x15, x16);
        }).toList();
    }

    private List<ItemQuantityPair> parseItemQuantityPairs(@NonNull List<String> item) {
        final var ingredients = new ArrayList<ItemQuantityPair>();
        for (var i = 0; i < 4; i++) {
            final var name = item.get(5 + i);
            if (name.equals("Blank")) {
                continue;
            }
            final var quantity = Integer.parseInt(item.get(11 + i));
            ingredients.add(new ItemQuantityPair(name, quantity));
        }
        return ingredients;
    }

}
