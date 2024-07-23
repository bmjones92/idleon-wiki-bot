package org.idleon.wiki.tables.customlists2.summonenemies;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.summonenemies.SummonEnemiesTable.SummoningMatch;

import java.util.List;
import java.util.stream.IntStream;

public class SummonEnemiesParser extends DataTableParser<List<List<String>>, SummonEnemiesTable> {

    public SummonEnemiesParser() {
        super("scripts.CustomLists2", "SummonEnemies");
    }

    @Override
    protected SummonEnemiesTable parseData(@NonNull List<List<String>> input) {
        final var matches = IntStream.range(0, input.size())
                .mapToObj(id -> parseMatch(input, id))
                .toList();
        final var bonuses = parseBonuses(input.get(6));

        return new SummonEnemiesTable(matches, bonuses);
    }

    private SummoningMatch parseMatch(@NonNull List<List<String>> input, int id) {
        if (input.get(5).get(id).equals("_")) {
            return null;
        }

        final var enemy = input.get(0).get(id);
        final var x1 = Integer.parseInt(input.get(1).get(id));
        final var x2 = Integer.parseInt(input.get(2).get(id));
        final var x3 = Integer.parseInt(input.get(3).get(id));
        final var name = TextTransformers.SPACES.transform(input.get(4).get(id));
        final var x5 = Integer.parseInt(input.get(5).get(id));
        final var x7 = Integer.parseInt(input.get(7).get(id));
        final var x8 = Integer.parseInt(input.get(8).get(id));
        return new SummoningMatch(enemy, x1, x2, x3, name, x5, x7, x8);
    }

    private List<String> parseBonuses(@NonNull List<String> input) {
        return input.stream()
                .map(TextTransformers.SPACES::transform)
                .map(bonus -> bonus.replace('<', '#').replace('{', '#'))
                .toList();
    }

}
