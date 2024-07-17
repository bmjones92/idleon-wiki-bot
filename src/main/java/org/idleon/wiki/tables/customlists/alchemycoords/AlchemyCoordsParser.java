package org.idleon.wiki.tables.customlists.alchemycoords;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.common.Coordinate;

import java.util.List;

/**
 * Table parser implementation for the AlchemyCoords table.
 */
public class AlchemyCoordsParser extends DataTableParser<List<List<List<Integer>>>, AlchemyCoordsTable> {

    /**
     * Creates a new AlchemyCoordsParser instance.
     */
    public AlchemyCoordsParser() {
        super("scripts.CustomLists", "AlchemyCoords");
    }

    @Override
    protected AlchemyCoordsTable parseData(@NonNull List<List<List<Integer>>> input) {
        final var str = parseCauldron(input.get(0));
        final var agi = parseCauldron(input.get(1));
        final var wis = parseCauldron(input.get(2));
        final var luk = parseCauldron(input.get(3));
        return new AlchemyCoordsTable(str, agi, wis, luk);
    }

    /**
     * Parses the coordinate values for an individual cauldron.
     * @param cauldron The cauldron to parse.
     * @return The list of parsed AlchemyCoordinates.
     */
    private List<Coordinate> parseCauldron(@NonNull List<List<Integer>> cauldron) {
        return cauldron.stream().map(this::parseBubble).toList();
    }

    /**
     * Parses the coordinate values for an individual bubble.
     * @param bubble The bubble to parse.
     * @return The parsed AlchemyCoordinate.
     */
    private Coordinate parseBubble(@NonNull List<Integer> bubble) {
        return new Coordinate(bubble.get(0), bubble.get(1));
    }

}
