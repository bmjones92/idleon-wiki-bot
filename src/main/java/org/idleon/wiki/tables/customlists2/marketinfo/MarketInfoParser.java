package org.idleon.wiki.tables.customlists2.marketinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.marketinfo.MarketInfoTable.MarketInfo;

import java.util.List;

public class MarketInfoParser extends DataTableParser<List<List<String>>, MarketInfoTable> {

    public MarketInfoParser() {
        super("scripts.CustomLists2", "MarketInfo");
    }

    @Override
    protected MarketInfoTable parseData(@NonNull List<List<String>> input) {
        return new MarketInfoTable(input.stream().map(this::parseMarketInfo).toList());
    }

    private MarketInfo parseMarketInfo(@NonNull List<String> info) {
        final var name = TextTransformers.TITLE.transform(info.get(0));
        final var description = TextTransformers.SPACES.transform(info.get(1)).replaceAll("[{}]", "#");
        final var x2 = Integer.parseInt(info.get(2));
        final var x3 = Double.parseDouble(info.get(3));
        final var x4 = Integer.parseInt(info.get(4));
        final var x5 = Double.parseDouble(info.get(5));
        final var x6 = Integer.parseInt(info.get(6));
        final var x7 = Integer.parseInt(info.get(7));
        final var x8 = Double.parseDouble(info.get(8));
        return new MarketInfo(name, description, x2, x3, x4, x5, x6, x7, x8);
    }

}
