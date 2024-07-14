package org.idleon.wiki.tables.customlists.starsigns;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

import static org.idleon.wiki.tables.customlists.starsigns.StarSignsTable.StarSign;

public class StarSignsParser extends DataTableParser<List<List<String>>, StarSignsTable> {

    public StarSignsParser() {
        super("scripts.CustomLists", "StarSigns");
    }

    @Override
    protected StarSignsTable parseData(@NonNull List<List<String>> input) {
        return new StarSignsTable(input.stream().map(this::parseStarSign).toList());
    }

    private StarSign parseStarSign(@NonNull List<String> sign) {
        final var title = TextTransformers.TITLE.transform(sign.get(0));
        final var description = sign.subList(1, sign.size()).stream()
                .filter(line -> !line.equals("_"))
                .map(TextTransformers.SENTENCE::transform)
                .toList();

        return new StarSign(title, description);
    }

}
