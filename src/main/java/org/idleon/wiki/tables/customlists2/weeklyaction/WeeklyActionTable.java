package org.idleon.wiki.tables.customlists2.weeklyaction;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class WeeklyActionTable extends ArrayGameTable<WeeklyActionTable.WeeklyAction> {

    public WeeklyActionTable(@NonNull Collection<WeeklyAction> items) {
        super(items);
    }

    public record WeeklyAction(
            @NonNull String description,
            double x1,
            int x2,
            @NonNull String key,
            @NonNull ActionType type
    ) {}

    public enum ActionType {
        Attack,
        Buff,
        Misc,
    }

}
