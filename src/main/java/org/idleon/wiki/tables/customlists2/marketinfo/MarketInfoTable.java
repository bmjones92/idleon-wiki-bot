package org.idleon.wiki.tables.customlists2.marketinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class MarketInfoTable extends ArrayGameTable<MarketInfoTable.MarketInfo> {

    public MarketInfoTable(@NonNull Collection<MarketInfo> items) {
        super(items);
    }

    public record MarketInfo(
            @NonNull String name,
            @NonNull String description,
            int x2,
            double x3,
            int x4,
            double x5,
            int x6,
            int x7,
            double x8
    ) {}

}
