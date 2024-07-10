package org.idleon.wiki.tables.customlists.animationoffsets;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class AnimationOffsetsParser extends DataTableParser<List<List<Integer>>, AnimationOffsetsTable> {

    public AnimationOffsetsParser() {
        super("scripts.CustomLists", "AnimationOffsets");
    }

    @Override
    protected AnimationOffsetsTable parseData(@NonNull List<List<Integer>> input) {
        return new AnimationOffsetsTable(input);
    }

}
