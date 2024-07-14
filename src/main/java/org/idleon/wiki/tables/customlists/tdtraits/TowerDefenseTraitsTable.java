package org.idleon.wiki.tables.customlists.tdtraits;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class TowerDefenseTraitsTable extends ArrayGameTable<TowerDefenseTraitsTable.Tower> {

    public TowerDefenseTraitsTable(@NonNull Collection<Tower> items) {
        super(items);
    }

    public record Tower(
            @NonNull Trait a,
            @NonNull Trait b
    ) {}

    public record Trait(
            @NonNull String description,
            int x2
    ) {}

}
