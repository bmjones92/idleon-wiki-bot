package org.idleon.wiki.tables.customlists2.dungeon3jobs;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class Dungeon3JobsTable extends ArrayGameTable<Dungeon3JobsTable.DungeonJob> {

    public Dungeon3JobsTable(@NonNull Collection<DungeonJob> items) {
        super(items);
    }

    public record DungeonJob(
            @NonNull String description,
            int quantity,
            int x2,
            boolean x3
    ) {}

}
