package org.idleon.wiki.tables.customlists2.randolisto2;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record RandoListo2Table(
        @NonNull List<String> mutations,
        @NonNull List<GamingImport> imports,
        @NonNull List<Integer> x3,
        @NonNull List<Integer> x6,
        @NonNull List<Integer> x7
) implements GameTable {

    public record GamingImport(
        @NonNull String name,
        @NonNull String flavor,
        @Nullable String description,
        @NonNull String effectText
    ) {}

}
