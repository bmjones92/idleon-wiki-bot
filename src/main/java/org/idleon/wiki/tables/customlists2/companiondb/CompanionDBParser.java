package org.idleon.wiki.tables.customlists2.companiondb;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.companiondb.CompanionDBTable.Companion;

import java.util.List;

public class CompanionDBParser extends DataTableParser<List<List<String>>, CompanionDBTable> {

    public CompanionDBParser() {
        super("scripts.CustomLists2", "CompanionDB");
    }

    @Override
    protected CompanionDBTable parseData(@NonNull List<List<String>> input) {
        return new CompanionDBTable(input.stream().map(this::parseCompanion).toList());
    }

    private Companion parseCompanion(@NonNull List<String> companion) {
        final var name = companion.get(0);
        final var description = TextTransformers.SPACES.transform(companion.get(1)).replaceAll("\\{", "");
        final var x3 = Integer.parseInt(companion.get(3));
        final var x4 = Integer.parseInt(companion.get(4));
        final var x5 = Integer.parseInt(companion.get(5));
        return new Companion(name, description, x3, x4, x5);
    }

}
