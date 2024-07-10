package org.idleon.wiki.tables.customlists.alchemycoords;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

/**
 * Contains screen coordinates for alchemy bubbles.
 * @param str The list of bubble in the strength cauldron.
 * @param agi The list of bubbles in the agility cauldron.
 * @param wis The list of bubbles in the wisdom cauldron.
 * @param luk The list of bubbles in the luck cauldron.
 */
public record AlchemyCoordsTable(
        @NonNull List<AlchemyCoordinate> str,
        @NonNull List<AlchemyCoordinate> agi,
        @NonNull List<AlchemyCoordinate> wis,
        @NonNull List<AlchemyCoordinate> luk
) implements GameTable {

    public record AlchemyCoordinate(int x, int y) {}

}
