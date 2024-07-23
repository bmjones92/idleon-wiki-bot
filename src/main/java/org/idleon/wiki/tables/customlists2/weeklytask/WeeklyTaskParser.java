package org.idleon.wiki.tables.customlists2.weeklytask;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.weeklytask.WeeklyTaskTable.WeeklyTask;

import java.util.List;

public class WeeklyTaskParser extends DataTableParser<List<List<String>>, WeeklyTaskTable> {

    public WeeklyTaskParser() {
        super("scripts.CustomLists2", "WeeklyTASK");
    }

    @Override
    protected WeeklyTaskTable parseData(@NonNull List<List<String>> input) {
        return new WeeklyTaskTable(input.stream().map(this::parseTask).toList());
    }

    private WeeklyTask parseTask(@NonNull List<String> input) {
        final var description = TextTransformers.SPACES.transform(input.get(0));
        final var x1 = Integer.parseInt(input.get(1));
        final var levelDescription = TextTransformers.SPACES.transform(input.get(2)).replace('{', '#');
        final var key = input.get(3);
        return new WeeklyTask(description, x1, levelDescription, key);
    }

}
