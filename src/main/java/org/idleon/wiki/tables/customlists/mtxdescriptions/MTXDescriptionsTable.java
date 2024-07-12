package org.idleon.wiki.tables.customlists.mtxdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record MTXDescriptionsTable(
        @NonNull List<String> cosmetics,
        @NonNull List<String> usables,
        @NonNull List<String> bonuses
) implements GameTable {}