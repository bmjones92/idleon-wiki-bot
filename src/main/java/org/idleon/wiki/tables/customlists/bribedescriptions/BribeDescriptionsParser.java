package org.idleon.wiki.tables.customlists.bribedescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.math.BigDecimal;
import java.util.List;

public class BribeDescriptionsParser extends DataTableParser<List<List<String>>, BribeDescriptionsTable> {

    public BribeDescriptionsParser() {
        super("scripts.CustomLists", "BribeDescriptions");
    }

    @Override
    protected BribeDescriptionsTable parseData(@NonNull List<List<String>> input) {
        return new BribeDescriptionsTable(input.stream().map(bribe -> {
            final var name = TextTransformers.TITLE.transform(bribe.get(0));
            final var description = TextTransformers.DESCRIPTION.transform(bribe.get(1));
            final var cost = new BigDecimal(bribe.get(2)).toBigInteger();
            final var x3 = bribe.get(3);
            final var bonusKey = bribe.get(4);
            final var x5 = bribe.get(5);
            return new BribeDescriptionsTable.BribeDescription(name, description, cost, x3, bonusKey, x5);
        }).toList());
    }

}
