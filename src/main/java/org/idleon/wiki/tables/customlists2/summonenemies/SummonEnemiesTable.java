package org.idleon.wiki.tables.customlists2.summonenemies;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record SummonEnemiesTable(
        @NonNull List<SummoningMatch> matches,
        @NonNull List<String> bonuses
) implements GameTable {

    public record SummoningMatch(
            @NonNull String enemy,
            int x1,
            int x2,
            int x3,
            @NonNull String name,
            int x5,
            int x7,
            int x8
    ) {}

}
