package org.idleon.wiki.tables.customlists2.petstats;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class PetStatsTable extends ArrayGameTable<List<PetStatsTable.PetStats>> {

    public PetStatsTable(@NonNull Collection<List<PetStats>> items) {
        super(items);
    }

    public record PetStats(
            @NonNull String mob,
            @Nullable Integer x1,
            int x2,
            int x3,
            int x4,
            int x5
    ) {}

}
