package org.idleon.wiki.tables.customlists2.shrineinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

import static org.idleon.wiki.tables.customlists2.shrineinfo.ShrineInfoTable.ShrineInfo;

public class ShrineInfoParser extends DataTableParser<List<List<String>>, ShrineInfoTable> {

    public ShrineInfoParser() {
        super("scripts.CustomLists2", "ShrineInfo");
    }

    @Override
    protected ShrineInfoTable parseData(@NonNull List<List<String>> input) {
        return new ShrineInfoTable(input.stream().map(this::parseShrineInfo).toList());
    }

    private ShrineInfo parseShrineInfo(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        final var description = TextTransformers.SPACES.transform(input.get(1));
        final var baseBonus = Integer.parseInt(input.get(2));
        final var bonusPerLevel = Integer.parseInt(input.get(3));
        final var x4 = Integer.parseInt(input.get(4));
        return new ShrineInfo(name, description, baseBonus, bonusPerLevel, x4);
    }

}
