package org.idleon.wiki.tables.customlists2.islandinfobox;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class IslandInfoboxTable extends ArrayGameTable<IslandInfoboxTable.IslandInfobox> {

    public IslandInfoboxTable(@NonNull Collection<IslandInfobox> items) {
        super(items);
    }

    public record IslandInfobox(
            int x0,
            int x1,
            int x2,
            int x3,
            int x4,
            int x5,
            int x6
    ) {}

}
