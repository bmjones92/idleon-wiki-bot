package org.idleon.wiki.tables.customlists.mtxdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class MTXDescriptionsParser extends DataTableParser<List<List<String>>, MTXDescriptionsTable> {

    public MTXDescriptionsParser() {
        super("scripts.CustomLists", "MTXdescriptions");
    }

    @Override
    protected MTXDescriptionsTable parseData(@NonNull List<List<String>> input) {
        final var cosmetics = parseTab(input.get(0));
        final var usables = parseTab(input.get(1));
        final var bonuses = parseTab(input.get(2));
        return new MTXDescriptionsTable(cosmetics, usables, bonuses);
    }

    private List<String> parseTab(@NonNull List<String> tab) {
        return tab.stream().filter(description -> !description.equals("COMINGSOON")).toList();
    }

}
