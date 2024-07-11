package org.idleon.wiki.tables.customlists.guildgptasks;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.guildgptasks.GuildGPTasksTable.GuildGPTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuildGPTasksParser extends DataTableParser<List<List<String>>, GuildGPTasksTable> {

    public GuildGPTasksParser() {
        super("scripts.CustomLists", "GuildGPtasks");
    }

    @Override
    protected GuildGPTasksTable parseData(@NonNull List<List<String>> input) {
        final var daily = new ArrayList<GuildGPTask>();
        final var weekly = new ArrayList<GuildGPTask>();

        input.stream().map(this::parseTask).filter(Objects::nonNull).forEach(task -> {
            if (task.points() == 10) {
                daily.add(task);
            } else if (task.points() == 30) {
                weekly.add(task);
            } else {
                throw new RuntimeException("Unexpected reward points for task '" + task.name() + "': " + task.points());
            }
        });
        return new GuildGPTasksTable(daily, weekly);
    }

    private GuildGPTask parseTask(@NonNull final List<String> input) {
        final var name = TextTransformers.TITLE.transform(input.get(0));
        if (name.equals("Filler")) {
            return null;
        }
        final var quantity = Integer.parseInt(input.get(1));
        final var points = Integer.parseInt(input.get(2));

        return new GuildGPTask(name, quantity, points);
    }

}
