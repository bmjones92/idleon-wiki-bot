package org.idleon.wiki.tables.customlists.statueinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.statueinfo.StatueInfoTable.StatueInfo;

import java.util.List;

public class StatueInfoParser extends DataTableParser<List<List<String>>, StatueInfoTable> {

    public StatueInfoParser() {
        super("scripts.CustomLists", "StatueInfo");
    }

    @Override
    protected StatueInfoTable parseData(@NonNull List<List<String>> input) {
        return new StatueInfoTable(input.stream().map(this::parseStatueInfo).toList());
    }

    private StatueInfo parseStatueInfo(@NonNull List<String> statue) {
        final var name = TextTransformers.TITLE.transform(statue.get(0));
        final var description = TextTransformers.SENTENCE.transform(statue.get(1));
        final var x2 = Double.parseDouble(statue.get(2));
        final var x3 = Double.parseDouble(statue.get(3));
        return new StatueInfo(name, description, x2, x3);
    }

}
