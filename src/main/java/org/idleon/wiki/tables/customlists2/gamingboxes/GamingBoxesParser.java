package org.idleon.wiki.tables.customlists2.gamingboxes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;
import java.util.Objects;

import static org.idleon.wiki.tables.customlists2.gamingboxes.GamingBoxesTable.GamingBox;

public class GamingBoxesParser extends DataTableParser<List<List<String>>, GamingBoxesTable> {

    public GamingBoxesParser() {
        super("scripts.CustomLists2", "GamingBoxes");
    }

    @Override
    protected GamingBoxesTable parseData(@NonNull List<List<String>> input) {
        return new GamingBoxesTable(input.stream().map(this::parseBox).filter(Objects::nonNull).toList());
    }

    private GamingBox parseBox(@NonNull List<String> box) {
        final var name = TextTransformers.SPACES.transform(box.get(0));
        if (name.equals("Empty Box")) {
            return null;
        }
        final var x1 = Integer.parseInt(box.get(1));
        final var x2 = Integer.parseInt(box.get(2));
        final var x3 = Integer.parseInt(box.get(3));
        final var x4 = Integer.parseInt(box.get(4));
        final var x5 = Integer.parseInt(box.get(5));
        final var x6 = Integer.parseInt(box.get(6));
        final var x7 = Integer.parseInt(box.get(7));
        final var x8 = Integer.parseInt(box.get(8));
        final var description = TextTransformers.SPACES.transform(box.get(9));
        final var x10 = Integer.parseInt(box.get(10));
        final var x11 = Integer.parseInt(box.get(11));
        final var x12 = Integer.parseInt(box.get(12));
        final var x13 = Integer.parseInt(box.get(13));
        return new GamingBox(name, x1, x2, x3, x4, x5, x6, x7, x8, description, x10, x11, x12, x13);
    }

}
