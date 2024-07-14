package org.idleon.wiki.tables.customlists.taskdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class TaskDescriptionsTable extends ArrayGameTable<List<TaskDescriptionsTable.TaskDescription>> {

    public TaskDescriptionsTable(@NonNull Collection<List<TaskDescription>> items) {
        super(items);
    }

    public record TaskDescription(
            @NonNull String name,
            @NonNull List<String> descriptions,
            @Nullable String completionDescription,
            int basePoints,
            int comp_0,
            boolean comp_1
    ) {}

}
