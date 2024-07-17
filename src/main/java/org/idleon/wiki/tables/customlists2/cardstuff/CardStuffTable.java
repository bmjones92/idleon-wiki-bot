package org.idleon.wiki.tables.customlists2.cardstuff;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class CardStuffTable extends ArrayGameTable<List<CardStuffTable.CardStuff>> {

    public CardStuffTable(@NonNull Collection<List<CardStuff>> items) {
        super(items);
    }

    public record CardStuff(
            @NonNull String source,
            @NonNull String id,
            double baseQuantity,
            @NonNull String description,
            double bonusPerLevel
    ) {}

}
