package org.idleon.wiki.tables.customlists.worshipinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class WorshipInfoTable extends ArrayGameTable<List<WorshipInfoTable.WorshipInfo>> {

    public WorshipInfoTable(@NonNull Collection<List<WorshipInfo>> items) {
        super(items);
    }

    public record WorshipInfo(
            int x0,
            int x1,
            int x2,
            int x3
    ) {}

}
