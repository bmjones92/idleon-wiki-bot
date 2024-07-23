package org.idleon.wiki.tables.customlists2.starquests;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.Coordinate;

import java.util.Collection;

public class StarQuestsTable extends ArrayGameTable<StarQuestsTable.StarQuest> {

    public StarQuestsTable(@NonNull Collection<StarQuest> items) {
        super(items);
    }

    public record StarQuest(
            int mapId,
            @NonNull Coordinate position,
            int magnitude,
            int x4,
            int numPlayers,
            int points,
            @NonNull String task,
            int type
    ) {}

}
