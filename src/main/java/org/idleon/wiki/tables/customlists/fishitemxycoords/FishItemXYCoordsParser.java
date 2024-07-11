package org.idleon.wiki.tables.customlists.fishitemxycoords;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

import static org.idleon.wiki.tables.customlists.fishitemxycoords.FishItemXYCoordsTable.FishItemXYCoords;

public class FishItemXYCoordsParser extends DataTableParser<List<List<String>>, FishItemXYCoordsTable> {

    public FishItemXYCoordsParser() {
        super("scripts.CustomLists", "FishItemXYcoords");
    }

    @Override
    protected FishItemXYCoordsTable parseData(@NonNull List<List<String>> input) {
        return new FishItemXYCoordsTable(input.stream().map(this::parseCoords).toList());
    }

    private FishItemXYCoords parseCoords(@NonNull List<String> coords) {
        final var x0 = parseElement(coords.get(0));
        final var x1 = parseElement(coords.get(1));
        final var x2 = parseElement(coords.get(2));
        final var x3 = parseElement(coords.get(3));
        final var x4 = parseElement(coords.get(4));
        final var x5 = parseElement(coords.get(5));
        final var x6 = parseElement(coords.get(6));
        return new FishItemXYCoords(x0, x1, x2, x3, x4, x5, x6);
    }

    private int parseElement(@NonNull String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            if (value.length() != 1) {
                throw new RuntimeException("Non-numeric element has length != 1: " + value);
            }
            return value.charAt(0);
        }
    }

}
