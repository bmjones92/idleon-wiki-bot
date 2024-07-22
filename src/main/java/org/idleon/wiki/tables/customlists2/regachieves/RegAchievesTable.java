package org.idleon.wiki.tables.customlists2.regachieves;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class RegAchievesTable extends ArrayGameTable<RegAchievesTable.RegAchievement> {

    public RegAchievesTable(@NonNull Collection<RegAchievement> items) {
        super(items);
    }

    public record RegAchievement(
            @NonNull String name,
            int x1,
            @NonNull String description,
            boolean isSteamExclusive,
            @NonNull List<String> rewards,
            int x4
    ) {}

}
