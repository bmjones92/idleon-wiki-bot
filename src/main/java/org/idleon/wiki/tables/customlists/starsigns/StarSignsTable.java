package org.idleon.wiki.tables.customlists.starsigns;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class StarSignsTable extends ArrayGameTable<StarSignsTable.StarSign> {

    public StarSignsTable(@NonNull Collection<StarSign> items) {
        super(items);
    }

    public record StarSign(
            @NonNull String title,
            @NonNull List<String> description
    ) {}

}
