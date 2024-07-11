package org.idleon.wiki.tables.customlists.mapdetails;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class MapDetailsTable extends ArrayGameTable<MapDetailsTable.MapDetails> {

    public MapDetailsTable(@NonNull Collection<MapDetails> items) {
        super(items);
    }

    public record MapDetails(
            @NonNull List<Integer> x0,
            @NonNull List<Integer> x1,
            @NonNull List<Integer> x2
    ) {}

}
