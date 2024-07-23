package org.idleon.wiki.tables.customlists2.tome;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class TomeTable extends ArrayGameTable<TomeTable.TomeTask> {

    public TomeTable(@NonNull Collection<TomeTask> items) {
        super(items);
    }

    public record TomeTask(
            @NonNull String task,
            int x1,
            int x2,
            int x3,
            @Nullable String tooltip
    ) {}

}
