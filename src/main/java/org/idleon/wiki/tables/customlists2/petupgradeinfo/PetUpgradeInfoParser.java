package org.idleon.wiki.tables.customlists2.petupgradeinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.petupgradeinfo.PetUpgradeInfoTable.BreedingUpgrade;

import java.util.List;

public class PetUpgradeInfoParser extends DataTableParser<List<List<String>>, PetUpgradeInfoTable> {

    public PetUpgradeInfoParser() {
        super("scripts.CustomLists2", "PetUpgradeINFO");
    }

    @Override
    protected PetUpgradeInfoTable parseData(@NonNull List<List<String>> input) {
        return new PetUpgradeInfoTable(input.stream().map(this::parseBreedingUpgrade).toList());
    }

    private BreedingUpgrade parseBreedingUpgrade(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        if (name.equals("Filler")) {
            return null;
        }

        final var mealId = input.get(3).equals("Blank") ? null : Integer.parseInt(input.get(3));
        final var x4 = Integer.parseInt(input.get(4));
        final var x5 = Double.parseDouble(input.get(5));
        final var x6 = Integer.parseInt(input.get(6));
        final var x7 = Double.parseDouble(input.get(7));
        final var maxLevel = Integer.parseInt(input.get(8));
        final var description = TextTransformers.SPACES.transform(input.get(9));
        final var bonusText = TextTransformers.SPACES.transform(input.get(10)).replace('}', '#');
        final var bonusPerLevel = Double.parseDouble(input.get(11));
        return new BreedingUpgrade(name, mealId, x4, x5, x6, x7, maxLevel, description, bonusText, bonusPerLevel);
    }

}
