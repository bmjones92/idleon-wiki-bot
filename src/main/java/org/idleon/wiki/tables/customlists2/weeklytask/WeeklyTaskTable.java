package org.idleon.wiki.tables.customlists2.weeklytask;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class WeeklyTaskTable extends ArrayGameTable<WeeklyTaskTable.WeeklyTask> {

    public WeeklyTaskTable(@NonNull Collection<WeeklyTask> items) {
        super(items);
    }

    public record WeeklyTask(
            @NonNull String description,
            int x1,
            @NonNull String levelMessage,
            @NonNull String key
    ) {}

}
