package org.idleon.wiki.tables.customlists2.cardstuff;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;
import java.util.Objects;

import static org.idleon.wiki.tables.customlists2.cardstuff.CardStuffTable.CardStuff;

public class CardStuffParser extends DataTableParser<List<List<List<String>>>, CardStuffTable> {

    public CardStuffParser() {
        super("scripts.CustomLists2", "CardStuff");
    }

    @Override
    protected CardStuffTable parseData(@NonNull List<List<List<String>>> input) {
        return new CardStuffTable(input.stream().map(this::parseCardSet).toList());
    }

    private List<CardStuff> parseCardSet(@NonNull List<List<String>> set) {
        return set.stream().map(this::parseCard).filter(Objects::nonNull).toList();
    }

    private CardStuff parseCard(@NonNull List<String> card) {
        final var source = card.get(0);
        if (source.equals("Blank")) {
            return null;
        }

        final var id = card.get(1);
        final var baseQuantity = Double.parseDouble(card.get(2));
        final var description = TextTransformers.SPACES.transform(card.get(3));
        final var bonusPerLevel = Double.parseDouble(card.get(4));
        return new CardStuff(source, id, baseQuantity, description, bonusPerLevel);
    }

}
