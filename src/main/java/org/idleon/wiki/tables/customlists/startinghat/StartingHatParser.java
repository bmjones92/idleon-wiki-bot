package org.idleon.wiki.tables.customlists.startinghat;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

import static org.idleon.wiki.tables.customlists.startinghat.StartingHatTable.StartingHat;

public class StartingHatParser extends DataTableParser<List<List<String>>, StartingHatTable> {

    public StartingHatParser() {
        super("scripts.CustomLists", "StartingHat");
    }

    @Override
    protected StartingHatTable parseData(@NonNull List<List<String>> input) {
        return new StartingHatTable(input.stream().map(this::parseHat).toList());
    }

    private StartingHat parseHat(@NonNull List<String> hat) {
        final var item = hat.get(0);
        final var key = hat.get(1).charAt(0);
        return new StartingHat(key, item);
    }

}
