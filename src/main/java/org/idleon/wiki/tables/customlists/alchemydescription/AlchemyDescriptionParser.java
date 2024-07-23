package org.idleon.wiki.tables.customlists.alchemydescription;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.ParserUtils;
import org.idleon.wiki.parser.transformer.TextTransformer;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.ItemQuantityPair;
import org.idleon.wiki.tables.common.LavaMathFunc;
import org.idleon.wiki.tables.customlists.alchemydescription.AlchemyDescriptionTable.AlchemyBubble;
import org.idleon.wiki.tables.customlists.alchemydescription.AlchemyDescriptionTable.AlchemyShopItem;
import org.idleon.wiki.tables.customlists.alchemydescription.AlchemyDescriptionTable.AlchemyVial;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Parser for the "AlchemyDescription" table in the "CustomLists" script.
 */
public class AlchemyDescriptionParser extends DataTableParser<List<List<List<String>>>, AlchemyDescriptionTable> {

    private static final int SHOP_COST_ITEM_INDEX = 5;

    private static final int SHOP_COST_QUANTITY_INDEX = 11;

    private static final TextTransformer DESCRIPTION_TRANSFORMER = TextTransformers.SPACES.builder()
            .withNumberPlaceholders('{')
            .build();

    /**
     * Parser constructor.
     */
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

    /**
     * Parses all alchemy bubbles for a specific cauldron.
     * @param input The raw cauldron data.
     * @return The parsed cauldron.
     */
    private List<AlchemyBubble> parseCauldron(@NonNull List<List<String>> input) {
        return input.stream().map(this::parseBubble).toList();
    }

    /**
     * Parses an alchemy bubble.
     * @param input The raw bubble data.
     * @return The parsed bubble.
     */
    private AlchemyBubble parseBubble(@NonNull List<String> input) {
        final var name = TextTransformers.TITLE.transform(input.get(0));
        final var func = LavaMathFunc.parse(input, 1);
        final var ingredients = parseBubbleIngredients(input);
        final var description = DESCRIPTION_TRANSFORMER.transform(input.get(9));
        final var isEquippable = TextTransformers.parseBoolean(input.get(10));
        final var bonus = input.get(15);
        return new AlchemyBubble(name, checkNotNull(func), ingredients, description, isEquippable, bonus);
    }

    /**
     * Parses the upgrade materials for the bubble.
     * @param input The raw bubble data.
     * @return The list of upgrade materials.
     */
    private List<ItemQuantityPair> parseBubbleIngredients(@NonNull List<String> input) {
        return IntStream.range(0, 4)
                .mapToObj(id -> ItemQuantityPair.parse(input, 5 + id, 11 + id))
                .filter(Objects::nonNull)
                .filter(pair -> !pair.item().equals("Blank"))
                .toList();
    }

    /**
     * Parses all vial information.
     * @param input The raw list of vial data.
     * @return The parsed vial.
     */
    private List<AlchemyVial> parseVials(@NonNull List<List<String>> input) {
        return input.stream().map(this::parseVial).toList();
    }

    /**
     * Parses information for a single vial.
     * @param input The raw vial data.
     * @return The parsed vial.
     */
    private AlchemyVial parseVial(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        final var func = LavaMathFunc.parse(input, 1);
        final var ingredients = parseVialIngredients(input);
        final var description = DESCRIPTION_TRANSFORMER.transform(input.get(9));
        final var x10 = Integer.parseInt(input.get(10));
        final var bonus = input.get(11);

        return new AlchemyVial(name, checkNotNull(func), ingredients, description, x10, bonus);
    }

    /**
     * Parses the bubble ingredients.
     * @param input The raw vial data.
     * @return The list of upgrade ingredients.
     */
    private List<String> parseVialIngredients(@NonNull List<String> input) {
        return input.subList(5, 9).stream()
                .filter(ParserUtils::nonBlank)
                .toList();
    }

    /**
     * Parses alchemy shop items.
     * @param input The raw shop data.
     * @return The parsed shop inventory.
     */
    private List<AlchemyShopItem> parseShopItems(@NonNull List<List<String>> input) {
        return input.stream().map(this::parseShopItem).toList();
    }

    /**
     * Parses an alchemy shop item.
     * @param input The raw shop item data.
     * @return The parsed shop item.
     */
    private AlchemyShopItem parseShopItem(@NonNull List<String> input) {
        final var name = TextTransformers.TITLE.transform(input.get(0));
        final var x1 = Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var x3 = Integer.parseInt(input.get(3));
        final var x4 = Double.parseDouble(input.get(4));
        final var cost = parseShopItemCost(input);
        final var description = TextTransformers.SPACES.transform(input.get(9));
        final var x10 = Integer.parseInt(input.get(10));
        final var x15 = Integer.parseInt(input.get(15));
        final var x16 = Integer.parseInt(input.get(16));

        return new AlchemyShopItem(name, x1, x2, x3, x4, cost, description, x10, x15, x16);
    }

    /**
     * Parses the alchemy shop item cost.
     * @param input The raw shop item data.
     * @return The list of item costs.
     */
    private List<ItemQuantityPair> parseShopItemCost(@NonNull List<String> input) {
        return IntStream.range(0, 4)
                .mapToObj(id -> ItemQuantityPair.parse(input, 5 + id, 11 + id))
                .filter(iq -> iq != null && ParserUtils.nonBlank(iq.item()))
                .toList();
    }

}
