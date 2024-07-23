package org.idleon.wiki.tables.customlists.alchemycoords;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;
import org.idleon.wiki.tables.common.Position;

import java.util.List;

/**
 * Contains screen coordinates for alchemy bubbles.
 * @param str The list of bubble in the strength cauldron.
 * @param agi The list of bubbles in the agility cauldron.
 * @param wis The list of bubbles in the wisdom cauldron.
 * @param luk The list of bubbles in the luck cauldron.
 */
public record AlchemyCoordsTable(
        @NonNull List<Position> str,
        @NonNull List<Position> agi,
        @NonNull List<Position> wis,
        @NonNull List<Position> luk
) implements GameTable {}
