package org.idleon.wiki.tables.customlists.startinghat;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class StartingHatTable extends ArrayGameTable<StartingHatTable.StartingHat> {

    public StartingHatTable(@NonNull Collection<StartingHat> items) {
        super(items);
    }

    public record StartingHat(
            @NonNull Character key,
            @NonNull String item
    ) {}

}
