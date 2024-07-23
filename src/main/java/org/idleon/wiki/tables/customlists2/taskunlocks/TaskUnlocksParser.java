package org.idleon.wiki.tables.customlists2.taskunlocks;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

import static org.idleon.wiki.tables.customlists2.taskunlocks.TaskUnlocksTable.TaskUnlock;

public class TaskUnlocksParser extends DataTableParser<List<List<List<List<String>>>>, TaskUnlocksTable> {

    public TaskUnlocksParser() {
        super("scripts.CustomLists2", "TaskUnlocks");
    }

    @Override
    protected TaskUnlocksTable parseData(@NonNull List<List<List<List<String>>>> input) {
        return new TaskUnlocksTable(input.stream().map(this::parseTaskCategory).toList());
    }

    private List<List<TaskUnlock>> parseTaskCategory(@NonNull List<List<List<String>>> input) {
        return input.stream().map(this::parseTaskGroup).toList();
    }

    private List<TaskUnlock> parseTaskGroup(@NonNull List<List<String>> input) {
        return input.stream().map(this::parseTaskUnlock).toList();
    }

    private TaskUnlock parseTaskUnlock(@NonNull List<String> input) {
        final var item = TextTransformers.SPACES.transform(input.get(0));
        final var x1 = Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        return new TaskUnlock(item, x1, x2);
    }

}
