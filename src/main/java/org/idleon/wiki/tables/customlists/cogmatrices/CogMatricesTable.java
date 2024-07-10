package org.idleon.wiki.tables.customlists.cogmatrices;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

/**
 *
 * @param adjacent The offsets for the "adjacent" cog.
 * @param diagonal The offsets for the "diagonal" cog.
 * @param left The offsets for the "left" cog.
 * @param right The offsets for the "right" cog.
 * @param down The offsets for the "down" cog.
 * @param up The offsets for the "up" cog.
 * @param x6 Unknown cog
 * @param x7 Unknown cog
 * @param corner The offsets for the "corner" cog.
 * @param x9 Unknown cog
 * @param yang The offsets for the "yang" cog.
 */
public record CogMatricesTable(
        @NonNull List<Offset> adjacent,
        @NonNull List<Offset> diagonal,
        @NonNull List<Offset> left,
        @NonNull List<Offset> right,
        @NonNull List<Offset> down,
        @NonNull List<Offset> up,
        @NonNull List<Offset> x6,
        @NonNull List<Offset> x7,
        @NonNull List<Offset> corner,
        @NonNull List<Offset> x9,
        @NonNull List<Offset> yang
) implements GameTable {

    public record Offset(
            int x,
            int y
    ) {}

}
