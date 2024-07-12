package org.idleon.wiki.tables.customlists.playerselectbg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

import static org.idleon.wiki.tables.customlists.playerselectbg.PlayerSelectBGTable.PlayerSelectBG;

public class PlayerSelectBGParser extends DataTableParser<List<List<String>>, PlayerSelectBGTable> {

    public PlayerSelectBGParser() {
        super("scripts.CustomLists", "PlayerSelectBG");
    }

    @Override
    protected PlayerSelectBGTable parseData(@NonNull List<List<String>> input) {
        return new PlayerSelectBGTable(input.stream().map(this::parsePlayerSelectBG).toList());
    }

    private PlayerSelectBG parsePlayerSelectBG(@NonNull List<String> data) {
        final var background = data.get(0);
        final var foreground = data.get(1);
        return new PlayerSelectBG(background, foreground);
    }

}
