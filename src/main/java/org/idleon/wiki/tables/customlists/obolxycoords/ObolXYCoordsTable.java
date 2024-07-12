package org.idleon.wiki.tables.customlists.obolxycoords;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record ObolXYCoordsTable(
        @NonNull List<ObolSlot> personal,
        @NonNull List<ObolSlot> family,
        @NonNull List<ObolSlot> upgrade,
        @NonNull List<ObolSlot> x3
) implements GameTable {

    public record ObolSlot(
            int x,
            int y,
            int shape,
            int levelRequirement
    ) {}

}
