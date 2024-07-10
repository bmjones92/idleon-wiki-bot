package org.idleon.wiki.tables.customlists.cardshidestats;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class CardsHideStatsTable extends ArrayGameTable<String> {

    public CardsHideStatsTable(@NonNull Collection<String> items) {
        super(items);
    }

}
