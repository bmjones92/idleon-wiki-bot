package org.idleon.wiki.tables.customlists.obolxycoords;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.obolxycoords.ObolXYCoordsTable.ObolSlot;

import java.util.List;

public class ObolXYCoordsParser extends DataTableParser<List<List<List<Integer>>>, ObolXYCoordsTable> {

    public ObolXYCoordsParser() {
        super("scripts.CustomLists", "ObolXYcoords");
    }

    @Override
    protected ObolXYCoordsTable parseData(@NonNull List<List<List<Integer>>> input) {
        final var personal = parseGroup(input.get(0));
        final var family = parseGroup(input.get(1));
        final var upgrade = parseGroup(input.get(2));
        final var x3 = parseGroup(input.get(3));
        return new ObolXYCoordsTable(personal, family, upgrade, x3);
    }

    private List<ObolSlot> parseGroup(@NonNull List<List<Integer>> coords) {
        return coords.stream().map(this::parseCoords).toList();
    }

    private ObolSlot parseCoords(@NonNull List<Integer> coords) {
        final var x = coords.get(0);
        final var y = coords.get(1);
        final var shape = coords.get(2);
        final var levelRequirement = coords.get(3);
        return new ObolSlot(x, y, shape, levelRequirement);
    }

}
