package org.idleon.wiki.tables.customlists.bribedescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.math.BigInteger;
import java.util.Collection;

public class BribeDescriptionsTable extends ArrayGameTable<BribeDescriptionsTable.BribeDescription> {

    public BribeDescriptionsTable(@NonNull Collection<BribeDescription> items) {
        super(items);
    }

    public record BribeDescription(
            @NonNull String name,
            @NonNull String description,
            @NonNull BigInteger cost,
            @NonNull String x3,
            @NonNull String bonusKey,
            @NonNull String x5
    ) {}

}
