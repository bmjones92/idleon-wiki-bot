package org.idleon.wiki.tables.customlists2.dungflurboshop;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.dungflurboshop.DungeonFlurboShopTable.FlurboShopItem;

import java.util.List;

public class DungeonFlurboShopParser extends DataTableParser<List<List<String>>, DungeonFlurboShopTable> {

    public DungeonFlurboShopParser() {
        super("scripts.CustomLists2", "DungFlurboShop");
    }

    @Override
    protected DungeonFlurboShopTable parseData(@NonNull List<List<String>> input) {
        return new DungeonFlurboShopTable(input.stream().map(this::parseItem).toList());
    }

    private FlurboShopItem parseItem(@NonNull List<String> item) {
        final var id = item.get(0);
        final var cost = Integer.parseInt(item.get(1));
        final var requiresPreviousUnlock = TextTransformers.parseBoolean(item.get(2));
        final var name = TextTransformers.SPACES.transform(item.get(3));
        final var description = TextTransformers.SPACES.transform(item.get(4));
        return new FlurboShopItem(id, cost, requiresPreviousUnlock, name, description);
    }

}
