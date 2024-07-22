package org.idleon.wiki.tables.customlists2.owlz;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.owlz.OwlzTable.FeatherActivity;
import org.idleon.wiki.tables.customlists2.owlz.OwlzTable.Upgrade;

import java.util.ArrayList;
import java.util.List;

public class OwlzParser extends DataTableParser<List<List<String>>, OwlzTable> {

    private static final int NUM_BONUS_LABELS = 8;

    private static final int FEATHER_UPGRADE_INDEX = 0;

    private static final int NUM_FEATHER_UPGRADES = 9;

    private static final int FISH_UPGRADE_INDEX = FEATHER_UPGRADE_INDEX + NUM_FEATHER_UPGRADES;

    private static final int NUM_FISH_UPGRADES = 12;

    private static final int FISH_TAR_UPGRADE_INDEX = FISH_UPGRADE_INDEX + NUM_FISH_UPGRADES;

    private static final int NUM_FISH_TAR_UPGRADES = 8;

    public OwlzParser() {
        super("scripts.CustomLists2", "Owlz");
    }

    @Override
    protected OwlzTable parseData(@NonNull List<List<String>> input) {
        final var featherActivity = parseFeatherActivity(input);
        final var fishActivity = parseFishActivity(input);
        return new OwlzTable(featherActivity, fishActivity);
    }

    private FeatherActivity parseFeatherActivity(@NonNull List<List<String>> input) {
        final var bonuses = parseBonuses(input, FEATHER_UPGRADE_INDEX);
        final var upgrades = parseUpgrades(input, FEATHER_UPGRADE_INDEX, NUM_FEATHER_UPGRADES);
        return new FeatherActivity(upgrades, bonuses);
    }

    private OwlzTable.FishActivity parseFishActivity(@NonNull List<List<String>> input) {
        final var bonuses = parseBonuses(input, FISH_UPGRADE_INDEX);
        final var pondUpgrades = parseUpgrades(input, FISH_UPGRADE_INDEX, NUM_FISH_UPGRADES);
        final var tarUpgrades = parseUpgrades(input, FISH_TAR_UPGRADE_INDEX, NUM_FISH_TAR_UPGRADES);
        return new OwlzTable.FishActivity(pondUpgrades, tarUpgrades, bonuses);
    }

    private List<Upgrade> parseUpgrades(@NonNull List<List<String>> input, int startIndex, int numUpgrades) {
        return input.subList(startIndex, startIndex + numUpgrades).stream().map(this::parseUpgrade).toList();
    }

    private Upgrade parseUpgrade(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0)).replace('|', ' ');
        final var x1 = (long) Double.parseDouble(input.get(1));
        final var x2 = Double.parseDouble(input.get(2));
        final var x3 = input.get(3).equals("Nah") ? null : (long) Double.parseDouble(input.get(3));
        final var description = input.get(4).equals("Nah") ? null : TextTransformers.SPACES.transform(input.get(5)).replace('|', ' ');
        final var magnitude = Integer.parseInt(input.get(6));
        return new Upgrade(name, x1, x2, x3, description, magnitude);
    }

    private List<String> parseBonuses(@NonNull List<List<String>> input, int startIndex) {
        final var bonuses = new ArrayList<String>(NUM_BONUS_LABELS);
        for (var i = 0; i < NUM_BONUS_LABELS; i++) {
            bonuses.add(TextTransformers.SPACES.transform(input.get(startIndex + i).get(4)).replace('{', '#'));
        }
        return bonuses;
    }

}
