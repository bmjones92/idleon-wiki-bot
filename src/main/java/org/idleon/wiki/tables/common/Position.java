package org.idleon.wiki.tables.common;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

import static com.google.common.base.Preconditions.checkElementIndex;

/**
 * Represents a two-dimensional coordinate.
 * @param x The x coordinate.
 * @param y The y coordinate.
 */
public record Position(int x, int y) {

    /**
     * Parses a position given the specified list and coordinate indices.
     * @param input The input list. Must be a list of either Integer or String.
     * @param xIndex The index of the x coordinate.
     * @param yIndex The index of the y coordinate.
     * @return The parsed Position.
     * @param <T> The element type.
     */
    public static <T> Position parse(@NonNull List<T> input, int xIndex, int yIndex) {
        checkElementIndex(xIndex, input.size());
        checkElementIndex(yIndex, input.size());

        if (input.get(xIndex) instanceof Integer x && input.get(yIndex) instanceof Integer y) {
            return new Position(x, y);
        } else if (input.get(xIndex) instanceof String x && input.get(yIndex) instanceof String y) {
            return new Position(Integer.parseInt(x), Integer.parseInt(y));
        } else {
            throw new RuntimeException("input must be of type Integer or String");
        }
    }

    /**
     * Parses a position given the specified list and coordinate start index.
     * @param input The input list. Must be a list of either Integer or String.
     * @param startIndex The start index of the coordinates.
     * @return The parsed Position.
     * @param <T> The element type.
     */
    public static <T> Position parse(@NonNull List<T> input, int startIndex) {
        return parse(input, startIndex, startIndex + 1);
    }

    /**
     * Parses a position located at the start of the specified list.
     * @param input The input list.
     * @return The parsed Position.
     * @param <T> The element type.
     */
    public static <T> Position parse(@NonNull List<T> input) {
        return parse(input, 0);
    }

}
