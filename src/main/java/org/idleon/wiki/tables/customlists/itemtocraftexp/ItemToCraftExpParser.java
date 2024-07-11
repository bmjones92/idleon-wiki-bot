package org.idleon.wiki.tables.customlists.itemtocraftexp;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.itemtocraftexp.ItemToCraftExpTable.CraftLevelExperience;

import java.util.List;

public class ItemToCraftExpParser extends DataTableParser<List<List<List<String>>>, ItemToCraftExpTable> {

    public ItemToCraftExpParser() {
        super("scripts.CustomLists", "ItemToCraftEXP");
    }

    @Override
    protected ItemToCraftExpTable parseData(@NonNull List<List<List<String>>> input) {
        return new ItemToCraftExpTable(input.stream().map(this::parseAnvilTab).toList());
    }

    private List<CraftLevelExperience> parseAnvilTab(@NonNull List<List<String>> tab) {
        return tab.stream().map(this::parseLevelExperience).toList();
    }

    private CraftLevelExperience parseLevelExperience(@NonNull List<String> item) {
        final var level = Integer.parseInt(item.get(0));
        final var experience = Integer.parseInt(item.get(1));
        return new CraftLevelExperience(level, experience);
    }

}
