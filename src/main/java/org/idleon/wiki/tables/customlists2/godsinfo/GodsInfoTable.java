package org.idleon.wiki.tables.customlists2.godsinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class GodsInfoTable extends ArrayGameTable<GodsInfoTable.GodInfo> {

    public GodsInfoTable(@NonNull Collection<GodInfo> items) {
        super(items);
    }

    public record GodInfo(
            @NonNull String name,
            @NonNull String linkBonus,
            @NonNull String minorLinkBonus,
            int x3,
            int x4,
            double x5,
            @NonNull String blessing,
            @NonNull String unlockMessage,
            int x8,
            int x9,
            int x10,
            int x11,
            int x12,
            int x13,
            int x14
    ) {}

}
