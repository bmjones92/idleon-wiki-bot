package org.idleon.wiki.tables.customlists2.sigildesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class SigilDescTable extends ArrayGameTable<SigilDescTable.SigilDescription> {

    public SigilDescTable(@NonNull Collection<SigilDescription> items) {
        super(items);
    }

    public record SigilDescription(
            @NonNull String name,
            @NonNull String description,
            @NonNull List<SigilTier> tiers
    ) {}

    public record SigilTier(
            int points,
            int effect
    ) {}

}
