package org.idleon.wiki.tables.customlists2.seedinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.seedinfo.SeedInfoTable.SeedInfo;

import java.util.List;

public class SeedInfoParser extends DataTableParser<List<List<String>>, SeedInfoTable> {

    public SeedInfoParser() {
        super("scripts.CustomLists2", "SeedInfo");
    }

    @Override
    protected SeedInfoTable parseData(@NonNull List<List<String>> input) {
        return new SeedInfoTable(input.stream().map(this::parseSeedInfo).toList());
    }

    private SeedInfo parseSeedInfo(@NonNull List<String> input) {
        final var name = TextTransformers.TITLE.transform(input.get(0));
        final var id = Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var x3 = Integer.parseInt(input.get(3));
        final var levelRequirement = Integer.parseInt(input.get(4));
        final var evolutionChance = Double.parseDouble(input.get(5));
        final var x6 = Double.parseDouble(input.get(6));
        return new SeedInfo(name, id, x2, x3, levelRequirement, evolutionChance, x6);
    }

}
