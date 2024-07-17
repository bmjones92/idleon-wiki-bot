package org.idleon.wiki.tables.customlists2.arcadeshopinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.LavaMathFunc;

import java.util.Collection;

public class ArcadeShopInfoTable extends ArrayGameTable<ArcadeShopInfoTable.ArcadeShopInfo> {

    public ArcadeShopInfoTable(@NonNull Collection<ArcadeShopInfo> items) {
        super(items);
    }

    public record ArcadeShopInfo(
            @NonNull String description,
            @NonNull LavaMathFunc func,
            @Nullable String x4,
            @NonNull String bonus
    ) {}

}
