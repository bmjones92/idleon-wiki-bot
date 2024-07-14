package org.idleon.wiki.tables.customlists.steamachieves;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SteamAchievementsTable extends ArrayGameTable<SteamAchievementsTable.SteamAchievement> {

    public SteamAchievementsTable(@NonNull Collection<SteamAchievement> items) {
        super(items);
    }

    public record SteamAchievement(
            int x0,
            int x1,
            int x2,
            int x3
    ) {}

}
