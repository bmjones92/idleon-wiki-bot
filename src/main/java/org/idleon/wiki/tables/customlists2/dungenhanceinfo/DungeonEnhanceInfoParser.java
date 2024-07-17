package org.idleon.wiki.tables.customlists2.dungenhanceinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class DungeonEnhanceInfoParser extends DataTableParser<List<List<List<String>>>, DungeonEnhanceInfoTable> {

    public DungeonEnhanceInfoParser() {
        super("scripts.CustomLists2", "DungEnhanceINFO");
    }

    @Override
    protected DungeonEnhanceInfoTable parseData(@NonNull List<List<List<String>>> input) {
        return new DungeonEnhanceInfoTable(input.stream().map(this::parseEnhancementCategory).toList());
    }

    private List<String> parseEnhancementCategory(@NonNull List<List<String>> category) {
        return category.stream().map(this::parseEnhancement).toList();
    }

    private String parseEnhancement(@NonNull List<String> enhancement) {
        final var template = TextTransformers.SPACES.transform(enhancement.get(0));
        final var minRoll = Integer.parseInt(enhancement.get(1));
        final var maxRoll = Integer.parseInt(enhancement.get(2));
        return String.format("(%d-%d)%s", minRoll, maxRoll, template);
    }

}
