package org.idleon.wiki.tables.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public record LabMainBonus(
        int id,
        int x,
        int y,
        int x3,
        int x4,
        double magnitude,
        @NonNull String name,
        @NonNull String description
) {

    public static LabMainBonus parse(@NonNull List<String> bonus) {
        final var id = Integer.parseInt(bonus.get(0));
        final var x = Integer.parseInt(bonus.get(1));
        final var y = Integer.parseInt(bonus.get(2));
        final var x3 = Integer.parseInt(bonus.get(3));
        final var x4 = Integer.parseInt(bonus.get(4));
        final var magnitude = Double.parseDouble(bonus.get(5));
        final var name = TextTransformers.SPACES.transform(bonus.get(6));
        final var description = TextTransformers.SPACES.transform(bonus.get(7));
        return new LabMainBonus(id, x, y, x3, x4, magnitude, name, description);
    }

}
