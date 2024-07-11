package org.idleon.wiki.tables.customlists.itemtocraftexp;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class ItemToCraftExpTable extends ArrayGameTable<List<ItemToCraftExpTable.CraftLevelExperience>> {

    /**
     *
     * @param level
     * @param experience
     */
    public record CraftLevelExperience(
            int level,
            int experience
    ) {}

    public ItemToCraftExpTable(@NonNull Collection<List<CraftLevelExperience>> items) {
        super(items);
    }

    public List<CraftLevelExperience> getAnvilTab(int tab) {
        return get(tab);
    }

}
