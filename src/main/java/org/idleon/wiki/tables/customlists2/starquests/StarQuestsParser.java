package org.idleon.wiki.tables.customlists2.starquests;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.Position;
import org.idleon.wiki.tables.customlists2.starquests.StarQuestsTable.StarQuest;

import java.util.List;

public class StarQuestsParser extends DataTableParser<List<List<String>>, StarQuestsTable> {

    private static final String DESCRIPTION_SUFFIX = " @ Progress:\\{/}";

    public StarQuestsParser() {
        super("scripts.CustomLists2", "StarQuests");
    }

    @Override
    protected StarQuestsTable parseData(@NonNull List<List<String>> input) {
        return new StarQuestsTable(input.stream().map(this::parseQuest).toList());
    }

    private StarQuest parseQuest(@NonNull List<String> input) {
        if (input.get(0).equals("_")) {
            return null;
        }

        final var mapId = Integer.parseInt(input.get(0));
        final var location = parseCoordinate(input);
        final var magnitude = Integer.parseInt(input.get(3));
        final var x4 = Integer.parseInt(input.get(4));
        final var numPlayers = Integer.parseInt(input.get(5));
        final var points = Integer.parseInt(input.get(6));
        final var description = TextTransformers.SPACES.transform(input.get(7))
                .replaceAll(DESCRIPTION_SUFFIX, "");
        final var type = Integer.parseInt(input.get(8));
        return new StarQuest(mapId, location, magnitude, x4, numPlayers, points, description, type);
    }

    private Position parseCoordinate(@NonNull List<String> input) {
        final var x = Integer.parseInt(input.get(1));
        final var y = Integer.parseInt(input.get(2));
        return new Position(x, y);
    }

}
