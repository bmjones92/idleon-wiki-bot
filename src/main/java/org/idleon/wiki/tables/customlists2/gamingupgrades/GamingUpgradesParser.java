package org.idleon.wiki.tables.customlists2.gamingupgrades;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.gamingupgrades.GamingUpgradesTable.GamingUpgrade;

import java.util.List;

public class GamingUpgradesParser extends DataTableParser<List<List<String>>, GamingUpgradesTable> {

    public GamingUpgradesParser() {
        super("scripts.CustomLists2", "GamingUpgrades");
    }

    @Override
    protected GamingUpgradesTable parseData(@NonNull List<List<String>> input) {
        return new GamingUpgradesTable(input.stream().map(this::parseUpgrade).toList());
    }

    private GamingUpgrade parseUpgrade(@NonNull List<String> upgrade) {
        final var name = TextTransformers.SPACES.transform(upgrade.get(0));
        final var x1 = Integer.parseInt(upgrade.get(1));
        final var x2 = Integer.parseInt(upgrade.get(2));
        final var x3 = Integer.parseInt(upgrade.get(3));
        final var x4 = Integer.parseInt(upgrade.get(4));
        final var description = parseDescription(upgrade.get(5));
        return new GamingUpgrade(name, x1, x2, x3, x4, description);
    }

    private String parseDescription(@NonNull String line) {
        line = line.replace('{', '#');
        return TextTransformers.SPACES.transform(line);
    }

}
