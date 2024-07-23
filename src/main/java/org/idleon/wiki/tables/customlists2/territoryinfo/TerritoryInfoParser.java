package org.idleon.wiki.tables.customlists2.territoryinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.territoryinfo.TerritoryInfoTable.TerritoryBattle;
import org.idleon.wiki.tables.customlists2.territoryinfo.TerritoryInfoTable.TerritoryEnemy;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class TerritoryInfoParser extends DataTableParser<List<List<String>>, TerritoryInfoTable> {

    private static final int MAX_ENEMIES = 5;

    private static final int BASE_ENEMY_INDEX = 8;

    public TerritoryInfoParser() {
        super("scripts.CustomLists2", "TerritoryInfo");
    }

    @Override
    protected TerritoryInfoTable parseData(@NonNull List<List<String>> input) {
        return new TerritoryInfoTable(input.stream().map(this::parseBattle).toList());
    }

    private TerritoryBattle parseBattle(@NonNull List<String> input) {
        final var background = input.get(0);
        final var x1 = Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var x3 = Integer.parseInt(input.get(3));
        final var name = TextTransformers.SPACES.transform(input.get(4));
        final var enemies = parseEnemies(input);
        return new TerritoryBattle(background, x1, x2, x3, name, enemies);
    }

    private List<TerritoryEnemy> parseEnemies(@NonNull List<String> input) {
        return IntStream.range(0, MAX_ENEMIES)
                .mapToObj(id -> parseEnemy(input, id))
                .filter(Objects::nonNull)
                .toList();
    }

    private TerritoryEnemy parseEnemy(@NonNull List<String> input, int id) {
        final var index = BASE_ENEMY_INDEX + (id * 4);

        final var name = input.get(index);
        if (name.matches("Mob\\d")) {
            return null;
        }

        final var hitpoints = (long) Double.parseDouble(input.get(index + 1));
        final var x2 = Integer.parseInt(input.get(index + 2));
        final var x3 = Integer.parseInt(input.get(index + 3));
        return new TerritoryEnemy(name, hitpoints, x2, x3);
    }

}
