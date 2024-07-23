package org.idleon.wiki.tables.customlists.anvilproductioninfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class AnvilProductionInfoTable extends ArrayGameTable<AnvilProductionInfoTable.AnvilProductionItem> {

    public AnvilProductionInfoTable(@NonNull Collection<AnvilProductionItem> items) {
        super(items);
    }

    /**
     * Describes a single anvil production item.
     * @param item The internal material of the item.
     * @param work The amount of work required to produce the item.
     * @param levelRequirement The level requirement for producing the item.
     * @param baseExperience The base experience granted for producing the item.
     */
    public record AnvilProductionItem(
            @NonNull String item,
            int work,
            int levelRequirement,
            int baseExperience
    ) {}

}
