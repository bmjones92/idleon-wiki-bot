package org.idleon.wiki.tables.customlists.maptype;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record MapTypeTable(
        @NonNull List<Integer> towns,
        @NonNull List<Integer> nonTowns
) implements GameTable {}
