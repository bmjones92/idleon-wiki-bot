package org.idleon.wiki.tables.customlists2.taskunlocks;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class TaskUnlocksTable extends ArrayGameTable<List<List<TaskUnlocksTable.TaskUnlock>>> {

    public TaskUnlocksTable(@NonNull Collection<List<List<TaskUnlock>>> items) {
        super(items);
    }

    public record TaskUnlock(
            @NonNull String item,
            int x1,
            int x2
    ) {}

}
