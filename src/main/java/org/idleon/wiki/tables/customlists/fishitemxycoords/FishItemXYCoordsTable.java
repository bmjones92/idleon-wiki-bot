package org.idleon.wiki.tables.customlists.fishitemxycoords;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class FishItemXYCoordsTable extends ArrayGameTable<FishItemXYCoordsTable.FishItemXYCoords> {

    public FishItemXYCoordsTable(@NonNull Collection<FishItemXYCoords> items) {
        super(items);
    }

    public record FishItemXYCoords(
            int x0,
            int x1,
            int x2,
            int x3,
            int x4,
            int x5,
            int x6
    ) {}

}
