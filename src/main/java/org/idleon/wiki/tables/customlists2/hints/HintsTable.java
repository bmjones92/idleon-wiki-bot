package org.idleon.wiki.tables.customlists2.hints;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class HintsTable extends ArrayGameTable<List<HintsTable.Hint>> {

    public record Hint(
            @NonNull String name,
            @Nullable Character icon,
            @NonNull List<String> description
    ) {}

    public HintsTable(@NonNull Collection<List<Hint>> items) {
        super(items);
    }

}
