package org.idleon.wiki.tables.customlists2.riftstuff;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.Coordinate;
import org.idleon.wiki.tables.customlists2.riftstuff.RiftStuffTable.RiftBonus;
import org.idleon.wiki.tables.customlists2.riftstuff.RiftStuffTable.RiftTask;
import org.idleon.wiki.tables.customlists2.riftstuff.RiftStuffTable.RiftWave;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class RiftStuffParser extends DataTableParser<List<List<String>>, RiftStuffTable> {

    /**
     * Set of task description suffixes to truncate.
     */
    private static final Set<String> TASK_SUFFIXES = Set.of(
            "@_YOU'VE_DEFEATED_{_SO_FAR...",
            "YOU'VE_KILLED_{_SO_FAR...",
            "YOU_HAVE_{_SO_FAR...",
            "YOU'VE_DONE_{_SO_FAR...",
            "YOUR_BEST_IS_{_SO_FAR..."
    );

    public RiftStuffParser() {
        super("scripts.CustomLists2", "RiftStuff");
    }

    @Override
    protected RiftStuffTable parseData(@NonNull List<List<String>> input) {
        final var tasks = parseTasks(input);
        final var bonuses = parseBonuses(input.get(1));
        final var waves = parseWaves(input);
        return new RiftStuffTable(tasks, bonuses, waves);
    }

    private List<RiftTask> parseTasks(@NonNull List<List<String>> input) {
        final var tasks = new ArrayList<RiftTask>();
        for (var i = 0; i < input.get(0).size(); i++) {
            tasks.add(parseTask(input, i));
        }
        return tasks;
    }

    private RiftTask parseTask(@NonNull List<List<String>> input, int id) {
        final var description = parseTaskDescription(input.get(0).get(id));
        final var quantity = Integer.parseInt(input.get(5).get(id));
        final var x6 = Integer.parseInt(input.get(6).get(id));
        return new RiftTask(description, quantity, x6);
    }

    private String parseTaskDescription(@NonNull String input) {
        final var suffix = TASK_SUFFIXES.stream()
                .filter(input::endsWith)
                .findFirst();

        if (suffix.isPresent()) {
            input = input.substring(0, input.length() - suffix.get().length());
        }
        return TextTransformers.SPACES.transform(input);
    }

    private List<RiftBonus> parseBonuses(@NonNull List<String> input) {
        final var bonusLength = 5;
        return IntStream.range(0, input.size() / bonusLength)
                .mapToObj(id -> input.subList(id * bonusLength, (id + 1) * bonusLength))
                .map(this::parseBonus)
                .toList();
    }

    private RiftBonus parseBonus(@NonNull List<String> input) {
        final var x = Integer.parseInt(input.get(0));
        final var y = Integer.parseInt(input.get(1));
        final var name = TextTransformers.SPACES.transform(input.get(2));
        return new RiftBonus(name, new Coordinate(x, y));
    }

    private List<RiftWave> parseWaves(@NonNull List<List<String>> input) {
        final var numWaves = Math.min(Math.min(input.get(2).size(), input.get(3).size()), input.get(4).size());
        return IntStream.range(0, numWaves)
                .mapToObj(id -> parseWave(input, id))
                .toList();
    }

    private RiftWave parseWave(@NonNull List<List<String>> input, int id) {
        final var enemy = input.get(2).get(id);
        final var x3 = Integer.parseInt(input.get(3).get(id));
        final var task = Integer.parseInt(input.get(4).get(id));
        return new RiftWave(enemy, x3, task);
    }

}
