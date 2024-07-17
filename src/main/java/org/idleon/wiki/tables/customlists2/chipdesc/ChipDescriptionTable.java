package org.idleon.wiki.tables.customlists2.chipdesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.ItemQuantityPair;

import java.util.Collection;
import java.util.List;

public class ChipDescriptionTable extends ArrayGameTable<ChipDescriptionTable.ChipDescription> {

    public ChipDescriptionTable(@NonNull Collection<ChipDescription> items) {
        super(items);
    }

    public record ChipDescription(
            @NonNull String name,
            @NonNull String description,
            @NonNull String shopDescription,
            @NonNull List<ItemQuantityPair> cost,
            boolean isLimitedPerPlayer,
            @NonNull String bonusName
    ) {}

}
