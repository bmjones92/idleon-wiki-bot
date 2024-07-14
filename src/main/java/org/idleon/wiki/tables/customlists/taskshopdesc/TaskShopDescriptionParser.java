package org.idleon.wiki.tables.customlists.taskshopdesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.taskshopdesc.TaskShopDescriptionTable.MeritShopItem;
import org.idleon.wiki.tables.customlists.taskshopdesc.TaskShopDescriptionTable.MeritTask;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TaskShopDescriptionParser extends DataTableParser<List<List<List<String>>>, TaskShopDescriptionTable> {

    public TaskShopDescriptionParser() {
        super("scripts.CustomLists", "TaskShopDesc");
    }

    @Override
    protected TaskShopDescriptionTable parseData(@NonNull List<List<List<String>>> input) {
        return new TaskShopDescriptionTable(input.stream().map(this::parseMeritShop).toList());
    }

    private List<MeritShopItem> parseMeritShop(@NonNull List<List<String>> shop) {
        return shop.stream().map(this::parseMeritShopItem).filter(Objects::nonNull).toList();
    }

    private MeritShopItem parseMeritShopItem(@NonNull List<String> item) {
        if (item.get(0).equals("IDK_YET") || item.get(6).equals("cost")) {
            return null;
        }

        final var description = parseDescription(item);
        final var task = parseMeritTask(item);
        final var numTiers = Integer.parseInt(item.get(5));
        final var costPerUpgrade = Integer.parseInt(item.get(6));
        final var variants = parseVariants(item.get(9));
        final var icon = item.get(10);
        final var x11 = Double.parseDouble(item.get(11));

        return new MeritShopItem(description, task, numTiers, costPerUpgrade, variants, icon, x11);
    }

    private MeritTask parseMeritTask(@NonNull List<String> item) {
        if (!TextTransformers.parseBoolean(item.get(2))) {
            return null;
        }
        final var minTier = Integer.parseInt(item.get(4));
        final var maxTier = Integer.parseInt(item.get(3));
        return new MeritTask(minTier, maxTier);
    }

    private String parseDescription(@NonNull List<String> item) {
        var description = item.get(0);
        if (!item.get(1).equals("Descline2")) {
            description += " " + item.get(1);
        }
        return TextTransformers.SPACES.transform(description);
    }

    private List<String> parseVariants(@NonNull String line) {
        if (line.equals("Blank420q")) {
            return null;
        }
        return Arrays.stream(line.split("\\|")).map(TextTransformers.SPACES::transform).toList();
    }

}
