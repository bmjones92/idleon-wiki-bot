package org.idleon.wiki.tables.customlists.talenticonnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class TalentIconNamesParser extends DataTableParser<List<String>, TalentIconNamesTable> {

    public TalentIconNamesParser() {
        super("scripts.CustomLists", "TalentIconNames");
    }

    @Override
    protected TalentIconNamesTable parseData(@NonNull List<String> input) {
        return new TalentIconNamesTable(input.stream().map(this::parseName).toList());
    }

    private String parseName(@NonNull String name) {
        return !name.equals("_") ? TextTransformers.TITLE.transform(name) : null;
    }

}
