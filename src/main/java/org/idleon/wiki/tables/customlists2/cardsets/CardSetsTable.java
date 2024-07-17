package org.idleon.wiki.tables.customlists2.cardsets;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class CardSetsTable extends ArrayGameTable<CardSetsTable.CardSet> {

    public CardSetsTable(@NonNull Collection<CardSet> items) {
        super(items);
    }

    public record CardSet(
        @NonNull String description,
        int bonusPerLevel,
        @NonNull String image
    ) {}

}
