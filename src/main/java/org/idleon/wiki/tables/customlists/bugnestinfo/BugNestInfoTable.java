package org.idleon.wiki.tables.customlists.bugnestinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class BugNestInfoTable extends ArrayGameTable<BugNestInfoTable.BugNestInfo> {

    public BugNestInfoTable(@NonNull Collection<BugNestInfo> items) {
        super(items);
    }

    public record BugNestInfo(
            int x0,
            int x1,
            int x2
    ) {}

}
