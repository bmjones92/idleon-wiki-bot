package org.idleon.wiki.tables.customlists2.jeweldesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.ItemQuantityPair;

import java.util.Collection;
import java.util.List;

public class JewelDescTable extends ArrayGameTable<JewelDescTable.JewelDesc> {

    public JewelDescTable(@NonNull Collection<JewelDesc> items) {
        super(items);
    }

    public record JewelDesc(
            int x,
            int y,
            int x2,
            @NonNull String description,
            @NonNull String shopDescription,
            @NonNull List<ItemQuantityPair> cost,
            @NonNull String name,
            double magnitude
    ) {}

}
