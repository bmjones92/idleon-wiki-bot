package org.idleon.wiki.tables.customlists.worshipbaseinfos;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class WorshipBaseInfoTable extends ArrayGameTable<WorshipBaseInfoTable.WorshipBaseInfo> {

    public WorshipBaseInfoTable(@NonNull Collection<WorshipBaseInfo> items) {
        super(items);
    }

    public record WorshipBaseInfo(
            int x0,
            int x1,
            @NonNull String enemy,
            int x3,
            int x4,
            int x5,
            int charge,
            int x7,
            int x8
    ) {}

}
