package org.idleon.wiki.tables.customlists2.cloudsmap;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.cloudsmap.CloudsMapTable.CloudsMapItem;

import java.util.List;

public class CloudsMapParser extends DataTableParser<List<List<Integer>>, CloudsMapTable> {

    public CloudsMapParser() {
        super("scripts.CustomLists2", "CloudsMap");
    }

    @Override
    protected CloudsMapTable parseData(@NonNull List<List<Integer>> input) {
        return null;
    }

    private CloudsMapItem parseItem(@NonNull List<Integer> item) {
        final var x0 = item.get(0);
        final var x1 = item.get(1);
        final var x2 = item.get(2);
        return new CloudsMapItem(x0, x1, x2);
    }

}
