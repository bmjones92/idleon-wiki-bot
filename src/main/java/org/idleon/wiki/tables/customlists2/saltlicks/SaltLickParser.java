package org.idleon.wiki.tables.customlists2.saltlicks;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.saltlicks.SaltLicksTable.SaltLickBonus;

import java.util.List;

public class SaltLickParser extends DataTableParser<List<List<String>>, SaltLicksTable> {

    public SaltLickParser() {
        super("scripts.CustomLists2", "SaltLicks");
    }

    @Override
    protected SaltLicksTable parseData(@NonNull List<List<String>> input) {
        return new SaltLicksTable(input.stream().map(this::parseBonus).toList());
    }

    private SaltLickBonus parseBonus(@NonNull List<String> input) {
        final var material = input.get(0);
        final var description = TextTransformers.SPACES.transform(input.get(1)).replace('{', '#');
        final var baseCost = Integer.parseInt(input.get(2));
        final var bonusPerLevel = Double.parseDouble(input.get(3));
        final var maxLevel = Integer.parseInt(input.get(4));
        final var costScalar = Double.parseDouble(input.get(5));
        return new SaltLickBonus(material, description, maxLevel, baseCost, costScalar, bonusPerLevel);
    }

}
