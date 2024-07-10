package org.idleon.wiki.tables.customlists.bossdetails;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class BossDetailsTable extends ArrayGameTable<BossDetailsTable.BossDetails> {

    public BossDetailsTable(@NonNull Collection<BossDetails> items) {
        super(items);
    }

    public record BossDetails(
            @NonNull BossDifficulty normal,
            @NonNull BossDifficulty chaotic,
            @NonNull BossDifficulty nightmare
    ) {}

    /**
     * Boss stats for a specific difficulty.
     * @param health The health stat.
     * @param defense The defense stat.
     * @param experience The amount of experience granted for slaying the boss.
     * @param keys The number of keys required to fight the boss.
     * @param damages The amount of damage dealt for each attack.
     */
    public record BossDifficulty(
            long health,
            int defense,
            long experience,
            int keys,
            @NonNull List<Integer> damages
    ) {}

}
