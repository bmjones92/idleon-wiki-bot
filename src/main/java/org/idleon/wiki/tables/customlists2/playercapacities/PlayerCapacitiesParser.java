package org.idleon.wiki.tables.customlists2.playercapacities;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.playercapacities.PlayerCapacitiesTable.CapacityGroup;
import org.idleon.wiki.tables.customlists2.playercapacities.PlayerCapacitiesTable.CapacityItem;

import java.util.List;

public class PlayerCapacitiesParser extends DataTableParser<List<List<List<String>>>, PlayerCapacitiesTable> {

    public PlayerCapacitiesParser() {
        super("scripts.CustomLists2", "PlayerCapacities");
    }

    @Override
    protected PlayerCapacitiesTable parseData(@NonNull List<List<List<String>>> input) {
        final var inventory = parseItems(input.get(0));
        final var storage = parseItems(input.get(1));
        final var tiers = parseCapacityTiers(input.get(2).get(0));
        final var types = parseCapacityGroups(input.get(2));
        return new PlayerCapacitiesTable(inventory, storage, tiers, types);
    }

    private List<CapacityItem> parseItems(@NonNull List<List<String>> input) {
        return input.stream().map(this::parseItem).toList();
    }

    private CapacityItem parseItem(@NonNull List<String> input) {
        final var x0 = Integer.parseInt(input.get(0));
        final var x1 = Integer.parseInt(input.get(1));
        final var itemName = input.get(2);
        return new CapacityItem(x0, x1, itemName);
    }

    private List<Integer> parseCapacityTiers(@NonNull List<String> input) {
        return input.stream().map(Integer::parseInt).toList();
    }

    private List<CapacityGroup> parseCapacityGroups(@NonNull List<List<String>> input) {
        return input.subList(1, input.size()).stream().map(this::parseCapacityGroup).toList();
    }

    private CapacityGroup parseCapacityGroup(@NonNull List<String> input) {
        final var groupName = input.get(0);
        final var items = input.subList(1, input.size()).stream()
                .filter(item -> !item.equals("MaxCapBag"))
                .map(item -> item.equals("Blank") ? null : item)
                .toList();
        return new CapacityGroup(groupName, items);
    }

}
