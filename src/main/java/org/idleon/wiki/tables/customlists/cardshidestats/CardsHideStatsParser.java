package org.idleon.wiki.tables.customlists.cardshidestats;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class CardsHideStatsParser extends DataTableParser<List<String>, CardsHideStatsTable> {

    public CardsHideStatsParser() {
        super("scripts.CustomLists", "CardsHideStats");
    }

    @Override
    protected CardsHideStatsTable parseData(@NonNull List<String> input) {
        return new CardsHideStatsTable(input);
    }

}
