package org.idleon.wiki.tables.customlists.refineryinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.ItemQuantityPair;

import java.util.Collection;
import java.util.List;

public class RefineryInfoTable extends ArrayGameTable<RefineryInfoTable.RefineryInfo> {

    public RefineryInfoTable(@NonNull Collection<RefineryInfo> items) {
        super(items);
    }

    public record RefineryInfo(
        @NonNull String output,
        @NonNull List<ItemQuantityPair> ingredients
    ) {}

}
