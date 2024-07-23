package org.idleon.wiki.tables.customlists2.weeklyshop;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.weeklyshop.WeeklyShopTable.WeeklyShopItem;

import java.util.List;

public class WeeklyShopParser extends DataTableParser<List<List<List<String>>>, WeeklyShopTable> {

    public WeeklyShopParser() {
        super("scripts.CustomLists2", "WeeklySHOP");
    }

    @Override
    protected WeeklyShopTable parseData(@NonNull List<List<List<String>>> input) {
        final var themes = parseItems(input.get(0));
        final var items = parseItems(input.get(1));
        return new WeeklyShopTable(themes, items);
    }

    private List<WeeklyShopItem> parseItems(@NonNull List<List<String>> input) {
        return input.stream().map(this::parseItem).toList();
    }

    private WeeklyShopItem parseItem(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        final var cost = Integer.parseInt(input.get(1));
        final var reward = input.get(2);
        final var description = TextTransformers.SPACES.transform(input.get(3));
        final var x4 = TextTransformers.parseBoolean(input.get(4));
        return new WeeklyShopItem(name, cost, reward, description, x4);
    }

}
