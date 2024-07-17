package org.idleon.wiki.tables.customlists2.companiondb;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class CompanionDBTable extends ArrayGameTable<CompanionDBTable.Companion> {

    public CompanionDBTable(@NonNull Collection<Companion> items) {
        super(items);
    }

    public record Companion(
            @NonNull String name,
            @NonNull String description,
            int x3,
            int x4,
            int x5
    ) {}

}
