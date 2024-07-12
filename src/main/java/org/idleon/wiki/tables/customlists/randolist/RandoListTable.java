package org.idleon.wiki.tables.customlists.randolist;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

public record RandoListTable() implements GameTable {

    public record ObolUnknown(
            @NonNull String name,
            int x1
    ) {}

}
