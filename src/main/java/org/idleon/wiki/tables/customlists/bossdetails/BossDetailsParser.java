package org.idleon.wiki.tables.customlists.bossdetails;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.bossdetails.BossDetailsTable.BossDetails;
import org.idleon.wiki.tables.customlists.bossdetails.BossDetailsTable.BossDifficulty;

import java.util.List;

public class BossDetailsParser extends DataTableParser<List<List<List<Integer>>>, BossDetailsTable> {

    public BossDetailsParser() {
        super("scripts.CustomLists", "BossDetails");
    }

    @Override
    protected BossDetailsTable parseData(@NonNull List<List<List<Integer>>> input) {
        return new BossDetailsTable(input.stream().map(boss -> {
            final var normal = parseDifficulty(boss, 0);
            final var chaotic = parseDifficulty(boss, 1);
            final var nightmare = parseDifficulty(boss, 2);
            return new BossDetails(normal, chaotic, nightmare);
        }).toList());
    }

    private BossDifficulty parseDifficulty(@NonNull List<List<Integer>> boss, int difficulty) {
        final var health = boss.get(0).get(difficulty);
        final var defense = boss.get(1).get(difficulty);
        final var experience = boss.get(2).get(difficulty);
        final var keys = boss.get(3).get(difficulty);
        final var damages = boss.get(4 + difficulty);
        return new BossDifficulty(health, defense, experience, keys, damages);
    }

}
