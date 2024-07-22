package org.idleon.wiki.tables.customlists2.regachieves;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.Arrays;
import java.util.List;

import static org.idleon.wiki.tables.customlists2.regachieves.RegAchievesTable.*;

public class RegAchievesParser extends DataTableParser<List<List<String>>, RegAchievesTable> {

    public RegAchievesParser() {
        super("scripts.CustomLists2", "RegAchieves");
    }

    @Override
    protected RegAchievesTable parseData(@NonNull List<List<String>> input) {
        return new RegAchievesTable(input.stream().map(this::parseAchievement).toList());
    }

    private RegAchievement parseAchievement(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        if (name.equals("FILLERZZZ ACH")) {
            return null;
        }

        final var x1 = Integer.parseInt(input.get(1));
        final var description = TextTransformers.SPACES.transform(input.get(2));
        final var isSteamExclusive = input.get(3).startsWith("*STEAM_EXCLUSIVE");
        final var rewards = parseRewards(input.get(3), isSteamExclusive);
        final var x4 = Integer.parseInt(input.get(4));

        return new RegAchievement(name, x1, description, isSteamExclusive, rewards, x4);
    }

    private List<String> parseRewards(@NonNull String input, boolean isSteamExclusive) {
        return Arrays.stream(input.split("\\*"))
                .skip(isSteamExclusive ? 2 : 1)
                .map(TextTransformers.SPACES::transform)
                .map(reward -> reward.replaceAll("&", "").replace('{', '+').trim())
                .filter(reward -> !reward.isEmpty())
                .toList();
    }

}
