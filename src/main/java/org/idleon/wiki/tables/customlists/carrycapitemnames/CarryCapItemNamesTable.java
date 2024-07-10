package org.idleon.wiki.tables.customlists.carrycapitemnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

/**
 *
 * @param mining
 * @param chopping
 * @param food
 * @param material
 * @param fish
 * @param bug
 * @param critter
 * @param soul
 */
public record CarryCapItemNamesTable(
        @NonNull List<String> mining,
        @NonNull List<String> chopping,
        @NonNull List<String> food,
        @NonNull List<String> material,
        @NonNull List<String> fish,
        @NonNull List<String> bug,
        @NonNull List<String> critter,
        @NonNull List<String> soul
) implements GameTable {}
