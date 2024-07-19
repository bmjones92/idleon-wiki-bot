package org.idleon.wiki.tables.customlists2.islandinfobox;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.islandinfobox.IslandInfoboxTable.IslandInfobox;

import java.util.List;

public class IslandInfoboxParser extends DataTableParser<List<List<Integer>>, IslandInfoboxTable> {

    public IslandInfoboxParser() {
        super("scripts.CustomLists2", "IslandInfobox");
    }

    @Override
    protected IslandInfoboxTable parseData(@NonNull List<List<Integer>> input) {
        return new IslandInfoboxTable(input.stream().map(this::parseInfobox).toList());
    }

    private IslandInfobox parseInfobox(@NonNull List<Integer> infobox) {
        final var x0 = infobox.get(0);
        final var x1 = infobox.get(1);
        final var x2 = infobox.get(2);
        final var x3 = infobox.get(3);
        final var x4 = infobox.get(4);
        final var x5 = infobox.get(5);
        final var x6 = infobox.get(6);
        return new IslandInfobox(x0, x1, x2, x3, x4, x5, x6);
    }

}
