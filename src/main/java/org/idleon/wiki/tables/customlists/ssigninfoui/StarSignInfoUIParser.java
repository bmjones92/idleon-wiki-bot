package org.idleon.wiki.tables.customlists.ssigninfoui;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.ssigninfoui.StarSignInfoUITable.StarSignInfo;

import java.util.List;

public class StarSignInfoUIParser extends DataTableParser<List<List<String>>, StarSignInfoUITable> {

    public StarSignInfoUIParser() {
        super("scripts.CustomLists", "SSignInfoUI");
    }

    @Override
    protected StarSignInfoUITable parseData(@NonNull List<List<String>> input) {
        return new StarSignInfoUITable(input.stream().map(this::parseStarSign).toList());
    }

    private StarSignInfo parseStarSign(@NonNull List<String> info) {
        final var id = Integer.parseInt(info.get(0));
        final var x = Integer.parseInt(info.get(1));
        final var y = Integer.parseInt(info.get(2));
        final var x3 = Integer.parseInt(info.get(3));
        final var cost = Integer.parseInt(info.get(4));
        return new StarSignInfo(id, x, y, x3, cost);
    }

}
