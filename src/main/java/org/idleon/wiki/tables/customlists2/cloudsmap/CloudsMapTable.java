package org.idleon.wiki.tables.customlists2.cloudsmap;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class CloudsMapTable extends ArrayGameTable<CloudsMapTable.CloudsMapItem> {

    public CloudsMapTable(@NonNull Collection<CloudsMapItem> items) {
        super(items);
    }

    public record CloudsMapItem(
            int x0,
            int x1,
            int x2
    ) {}

}
