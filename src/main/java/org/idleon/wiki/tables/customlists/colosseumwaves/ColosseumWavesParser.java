package org.idleon.wiki.tables.customlists.colosseumwaves;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ColosseumWavesParser extends DataTableParser<List<List<List<List<String>>>>, ColosseumWavesTable> {

    public ColosseumWavesParser() {
        super("scripts.CustomLists", "ColosseumWaves");
    }

    @Override
    protected ColosseumWavesTable parseData(@NonNull List<List<List<List<String>>>> input) {
        return new ColosseumWavesTable(input.stream().map(this::parseColosseum).toList());
    }

    private List<List<ColosseumWavesTable.EnemySpawn>> parseColosseum(@NonNull List<List<List<String>>> colosseum) {
        return colosseum.stream().map(this::parseWave).toList();
    }

    private List<ColosseumWavesTable.EnemySpawn> parseWave(@NonNull List<List<String>> wave) {
        return wave.stream().map(this::parseEnemySpawn).toList();
    }

    private ColosseumWavesTable.EnemySpawn parseEnemySpawn(@NonNull List<String> enemy) {
        final var enemyName = enemy.get(0);
        final var quantity = Integer.parseInt(enemy.get(1));
        final var spawnPointId = Integer.parseInt(enemy.get(2));
        final var x3 = Integer.parseInt(enemy.get(3));
        return new ColosseumWavesTable.EnemySpawn(enemyName, quantity, spawnPointId, x3);
    }

}
