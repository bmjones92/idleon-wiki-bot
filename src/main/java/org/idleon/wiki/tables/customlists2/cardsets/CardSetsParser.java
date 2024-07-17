package org.idleon.wiki.tables.customlists2.cardsets;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.cardsets.CardSetsTable.CardSet;

import java.util.List;

public class CardSetsParser extends DataTableParser<List<List<String>>, CardSetsTable> {

    public CardSetsParser() {
        super("scripts.CustomLists2", "CardSets");
    }

    @Override
    protected CardSetsTable parseData(@NonNull List<List<String>> input) {
        return new CardSetsTable(input.stream().map(this::parseCardSet).toList());
    }

    private CardSet parseCardSet(@NonNull List<String> set) {
        final var description = TextTransformers.SPACES.transform(set.get(0));
        final var bonusPerTier = Integer.parseInt(set.get(1));
        final var image = set.get(2);
        return new CardSet(description, bonusPerTier, image);
    }

}
