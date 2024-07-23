package org.idleon.wiki.tables.customlists2.weeklyboss;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.weeklyboss.WeeklyBossTable.WeeklyBoss;

import java.util.List;

public class WeeklyBossParser extends DataTableParser<List<List<String>>, WeeklyBossTable> {

    public WeeklyBossParser() {
        super("scripts.CustomLists2", "WeeklyBOSS");
    }

    @Override
    protected WeeklyBossTable parseData(@NonNull List<List<String>> input) {
        return new WeeklyBossTable(input.stream().map(this::parseBoss).toList());
    }

    private WeeklyBoss parseBoss(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        final var x1 = Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var x3 = Integer.parseInt(input.get(3));
        final var x4 = Integer.parseInt(input.get(4));
        final var x5 = Double.parseDouble(input.get(5));
        final var x6 = Integer.parseInt(input.get(6));
        final var x7 = Integer.parseInt(input.get(7));
        final var x8 = Integer.parseInt(input.get(8));
        return new WeeklyBoss(name, x1, x2, x3, x4, x5, x6, x7, x8);
    }

}
