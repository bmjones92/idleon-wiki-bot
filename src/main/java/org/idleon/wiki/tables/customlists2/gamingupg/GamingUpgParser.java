package org.idleon.wiki.tables.customlists2.gamingupg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.gamingupg.GamingUpgTable.GamingUpgrade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamingUpgParser extends DataTableParser<List<List<String>>, GamingUpgTable> {

    private static final Map<String, String> replacements = new HashMap<>();

    static {
        replacements.put("_\\(}\\)\\._Total_bonus:_x\\{₣", ".");
        replacements.put("_Total_Bonus:_+\\{%_Spd", "");
    }

    public GamingUpgParser() {
        super("scripts.CustomLists2", "GamingUpg");
    }

    @Override
    protected GamingUpgTable parseData(@NonNull List<List<String>> input) {
        return new GamingUpgTable(input.stream().map(this::parseUpgrade).toList());
    }

    private GamingUpgrade parseUpgrade(@NonNull List<String> upgrade) {
        final var description = parseDescription(upgrade.get(0));
        final var x1 = Integer.parseInt(upgrade.get(1));
        final var x2 = Integer.parseInt(upgrade.get(2));
        final var name = TextTransformers.SPACES.transform(upgrade.get(3)).replace('|', ' ');
        return new GamingUpgrade(description, x1, x2, name);
    }

    private String parseDescription(@NonNull String template) {
        for (var replacement : replacements.entrySet()) {
            template = template.replaceAll(replacement.getKey(), replacement.getValue());
        }
        return TextTransformers.SPACES.transform(template);
    }

}
