package org.idleon.wiki.tables.customlists.startupimginst;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.startupimginst.StartupImageInstanceTable.StartupImageInstance;

import java.util.List;

public class StartupImageInstanceParser extends DataTableParser<List<List<Integer>>, StartupImageInstanceTable> {

    public StartupImageInstanceParser() {
        super("scripts.CustomLists", "StartupImgInst");
    }

    @Override
    protected StartupImageInstanceTable parseData(@NonNull List<List<Integer>> input) {
        return new StartupImageInstanceTable(input.stream().map(this::parseImageInstance).toList());
    }

    private StartupImageInstance parseImageInstance(@NonNull List<Integer> image) {
        final var x0 = image.get(0);
        final var x1 = image.get(1);
        final var x2 = image.get(2);
        final var x3 = image.get(3);
        final var x4 = image.get(4);
        final var x5 = image.get(5);
        final var x6 = image.get(6);
        final var x7 = image.get(7);
        return new StartupImageInstance(x0, x1, x2, x3, x4, x5, x6, x7);
    }

}
