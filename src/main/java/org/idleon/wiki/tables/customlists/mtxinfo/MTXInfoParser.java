package org.idleon.wiki.tables.customlists.mtxinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.mtxinfo.MTXInfoTable.MTXInfo;

import java.util.List;

public class MTXInfoParser extends DataTableParser<List<List<List<List<String>>>>, MTXInfoTable> {

    public MTXInfoParser() {
        super("scripts.CustomLists", "MTXinfo");
    }

    @Override
    protected MTXInfoTable parseData(@NonNull List<List<List<List<String>>>> input) {
        final var cosmetics = parseTab(input.get(0));
        final var usables = parseTab(input.get(1));
        final var bonuses = parseTab(input.get(2));
        return new MTXInfoTable(cosmetics, usables, bonuses);
    }

    private List<List<MTXInfo>> parseTab(@NonNull List<List<List<String>>> tab) {
        return tab.stream().map(this::parseCategory).toList();
    }

    private List<MTXInfo> parseCategory(@NonNull List<List<String>> category) {
        return category.stream().map(this::parseInfo).toList();
    }

    private MTXInfo parseInfo(@NonNull List<String> info) {
        final var key = info.get(0);

        final var title = TextTransformers.TITLE.transform(info.get(1));
        if (title.equals("Name of Item")) {
            return null;
        }

        final var description = TextTransformers.SENTENCE.transform(info.get(2));
        final var cost = Integer.parseInt(info.get(3));
        final var x4 = Integer.parseInt(info.get(4));
        final var maxPurchases = Integer.parseInt(info.get(5));
        final var x6 = info.get(6).equals("1");
        final var costIncrease = Integer.parseInt(info.get(7));
        return new MTXInfo(key, title, description, cost, x4, maxPurchases, x6, costIncrease);
    }

}
