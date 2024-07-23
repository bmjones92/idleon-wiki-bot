package org.idleon.wiki.tables.customlists2.skullshopdesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.skullshopdesc.SkullShopDescTable.SkullShopItem;

import java.util.List;

public class SkullShopDescParser extends DataTableParser<List<List<String>>, SkullShopDescTable> {

    public SkullShopDescParser() {
        super("scripts.CustomLists2", "SkullShopDesc");
    }

    @Override
    protected SkullShopDescTable parseData(@NonNull List<List<String>> input) {
        return new SkullShopDescTable(input.stream().map(this::parseItem).toList());
    }

    private static final String SUFFIX_TO_TRUNCATE = " Current bonus is {x";

    private SkullShopItem parseItem(@NonNull List<String> input) {
        var description = TextTransformers.SPACES.transform(input.get(0)).replace('|', ' ');
        if (description.endsWith(SUFFIX_TO_TRUNCATE)) {
            description = description.substring(0, description.length() - SUFFIX_TO_TRUNCATE.length());
        }

        final var cost = Integer.parseInt(input.get(1));
        final var rewardItem = TextTransformers.parseBoolean(input.get(2)) ? input.get(3) : null;
        final var quantity = Integer.parseInt(input.get(4));
        return new SkullShopItem(description, cost, rewardItem, quantity);
    }

}
