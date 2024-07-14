package org.idleon.wiki.tables.customlists.startupimginst;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class StartupImageInstanceTable extends ArrayGameTable<StartupImageInstanceTable.StartupImageInstance> {

    public StartupImageInstanceTable(@NonNull Collection<StartupImageInstance> items) {
        super(items);
    }

    public record StartupImageInstance(
            int x0,
            int x1,
            int x2,
            int x3,
            int x4,
            int x5,
            int x6,
            int x7
    ) {}

}
