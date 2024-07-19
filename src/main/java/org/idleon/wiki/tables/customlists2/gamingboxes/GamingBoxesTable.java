package org.idleon.wiki.tables.customlists2.gamingboxes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class GamingBoxesTable extends ArrayGameTable<GamingBoxesTable.GamingBox> {

    public GamingBoxesTable(@NonNull Collection<GamingBox> items) {
        super(items);
    }

    public record GamingBox(
            @NonNull String name,
            int x1,
            int x2,
            int x3,
            int x4,
            int x5,
            int x6,
            int x7,
            int x8,
            @NonNull String description,
            int x10,
            int x11,
            int x12,
            int x13
    ) {}

}
