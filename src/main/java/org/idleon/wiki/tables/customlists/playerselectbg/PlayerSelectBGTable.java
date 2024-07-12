package org.idleon.wiki.tables.customlists.playerselectbg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class PlayerSelectBGTable extends ArrayGameTable<PlayerSelectBGTable.PlayerSelectBG> {

    public PlayerSelectBGTable(@NonNull Collection<PlayerSelectBG> items) {
        super(items);
    }

    public record PlayerSelectBG(
            @NonNull String backgroundImage,
            @NonNull String foregroundImage
    ) {}

}
