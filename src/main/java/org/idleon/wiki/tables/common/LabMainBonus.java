package org.idleon.wiki.tables.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

/**
 * Describes a laboratory mainframe node.
 * @param id          The id of the node.
 * @param name        The human-readable name of the bonus.
 * @param description The human-readable description of the bonus.
 * @param position    The position of the node within the mainframe.
 * @param magnitude   The magnitude of the bonus.
 * @param x3          Unknown
 * @param x4          Unknown
 */
public record LabMainBonus(
        int id,
        @NonNull String name,
        @NonNull String description,
        @NonNull Position position,
        double magnitude,
        int x3,
        int x4
) {

    /**
     * Parses a lab mainframe node.
     * @param input The raw input data.
     * @return The parsed mainframe bonus.
     */
    public static LabMainBonus parse(@NonNull List<String> input) {
        final var id = Integer.parseInt(input.get(0));
        final var x = Integer.parseInt(input.get(1));
        final var y = Integer.parseInt(input.get(2));
        final var x3 = Integer.parseInt(input.get(3));
        final var x4 = Integer.parseInt(input.get(4));
        final var magnitude = Double.parseDouble(input.get(5));
        final var name = TextTransformers.SPACES.transform(input.get(6));
        final var description = TextTransformers.SPACES.transform(input.get(7));
        return new LabMainBonus(id, name, description, new Position(x, y), magnitude, x3, x4);
    }

}
