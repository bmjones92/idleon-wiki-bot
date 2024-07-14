package org.idleon.wiki.tables.customlists2.achievespacing;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.achievespacing.AchieveSpacingTable.AchieveSpacing;

import java.util.List;

public class AchieveSpacingParser extends DataTableParser<List<List<Integer>>, AchieveSpacingTable> {

    public AchieveSpacingParser() {
        super("scripts.CustomLists2", "AchieveSpacing");
    }

    @Override
    protected AchieveSpacingTable parseData(@NonNull List<List<Integer>> input) {
        return new AchieveSpacingTable(input.stream().map(this::parseAchieveSpacing).toList());
    }

    private AchieveSpacing parseAchieveSpacing(@NonNull List<Integer> spacing) {
        final var x0 = spacing.get(0);
        final var x1 = spacing.get(1);
        final var x2 = spacing.get(2);
        final var x3 = spacing.get(3);
        return new AchieveSpacing(x0, x1, x2, x3);
    }

}
