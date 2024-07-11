package org.idleon.wiki.tables.customlists.colosseumwaves;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class ColosseumWavesTable extends ArrayGameTable<List<List<ColosseumWavesTable.EnemySpawn>>> {

    public ColosseumWavesTable(@NonNull Collection<List<List<ColosseumWavesTable.EnemySpawn>>> items) {
        super(items);
    }

    /**
     * Details an individual enemy spawn for a wave.
     * @param enemyName The internal name of the enemy being spawned.
     * @param quantity The number of enemies to spawn.
     * @param spawnPointId The spawn point
     * @param x3 Unknown
     */
    public record EnemySpawn(
            @NonNull String enemyName,
            int quantity,
            int spawnPointId,
            int x3
    ) {}

}
