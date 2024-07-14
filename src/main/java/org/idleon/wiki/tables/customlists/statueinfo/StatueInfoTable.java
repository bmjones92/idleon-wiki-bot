package org.idleon.wiki.tables.customlists.statueinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class StatueInfoTable extends ArrayGameTable<StatueInfoTable.StatueInfo> {

    public StatueInfoTable(@NonNull Collection<StatueInfo> items) {
        super(items);
    }

    public record StatueInfo(
            @NonNull String name,
            @NonNull String bonus,
            double x2,
            double x3
    ) {}

}
