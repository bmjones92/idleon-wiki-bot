package org.idleon.wiki.tables.customlists2.sigildesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.sigildesc.SigilDescTable.SigilDescription;
import org.idleon.wiki.tables.customlists2.sigildesc.SigilDescTable.SigilTier;

import java.util.List;
import java.util.stream.IntStream;

public class SigilDescParser extends DataTableParser<List<List<String>>, SigilDescTable> {

    private static final int NUM_SIGIL_TIERS = 3;

    public SigilDescParser() {
        super("scripts.CustomLists2", "SigilDesc");
    }

    @Override
    protected SigilDescTable parseData(@NonNull List<List<String>> input) {
        return new SigilDescTable(input.stream().map(this::parseSigil).toList());
    }

    private SigilDescription parseSigil(@NonNull List<String> input) {
        final var name = TextTransformers.TITLE.transform(input.get(0));
        final var description = TextTransformers.SPACES.transform(input.get(6));
        final var tiers = parseTiers(input);
        return new SigilDescription(name, description, tiers);
    }

    private List<SigilTier> parseTiers(@NonNull List<String> input) {
        return IntStream.range(0, NUM_SIGIL_TIERS)
                .mapToObj(tier -> parseTier(input, tier))
                .toList();
    }

    private SigilTier parseTier(@NonNull List<String> input, int tier) {
        final var points = Integer.parseInt(input.get(tier == 2 ? 7 : tier + 1));
        final var effect = Integer.parseInt(input.get(tier == 2 ? 8 : tier + 3));
        return new SigilTier(points, effect);
    }

}
