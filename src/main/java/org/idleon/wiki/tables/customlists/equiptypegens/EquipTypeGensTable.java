package org.idleon.wiki.tables.customlists.equiptypegens;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record EquipTypeGensTable(
        @NonNull List<String> x0,
        @NonNull List<String> tools,
        @NonNull List<String> x2
) implements GameTable {}
