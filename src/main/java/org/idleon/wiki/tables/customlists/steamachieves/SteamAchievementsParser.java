package org.idleon.wiki.tables.customlists.steamachieves;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.steamachieves.SteamAchievementsTable.SteamAchievement;

import java.util.List;

public class SteamAchievementsParser extends DataTableParser<List<List<Integer>>, SteamAchievementsTable> {

    public SteamAchievementsParser() {
        super("scripts.CustomLists", "SteamAchieves");
    }

    @Override
    protected SteamAchievementsTable parseData(@NonNull List<List<Integer>> input) {
        return new SteamAchievementsTable(input.stream().map(this::parseAchievement).toList());
    }

    private SteamAchievement parseAchievement(@NonNull List<Integer> achievement) {
        final var x0 = achievement.get(0);
        final var x1 = achievement.get(1);
        final var x2 = achievement.get(2);
        final var x3 = achievement.get(3);
        return new SteamAchievement(x0, x1, x2, x3);
    }

}
