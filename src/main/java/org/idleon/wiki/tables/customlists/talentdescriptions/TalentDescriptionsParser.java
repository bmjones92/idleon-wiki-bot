package org.idleon.wiki.tables.customlists.talentdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.talentdescriptions.TalentDescriptionsTable.TalentDescription;
import org.idleon.wiki.util.LavaMathFunc;

import java.util.ArrayList;
import java.util.List;

public class TalentDescriptionsParser extends DataTableParser<List<List<List<String>>>, TalentDescriptionsTable> {

    private static final int MAX_FUNCTIONS = 2;

    public TalentDescriptionsParser() {
        super("scripts.CustomLists", "TalentDescriptions");
    }

    @Override
    protected TalentDescriptionsTable parseData(@NonNull List<List<List<String>>> input) {
        return new TalentDescriptionsTable(input.stream().map(this::parseTalent).toList());
    }

    private TalentDescription parseTalent(@NonNull List<List<String>> talent) {
        final var description = TextTransformers.SENTENCE.transform(talent.get(0).get(0));
        final var functions = parseFunctions(talent.get(1));
        final var variable = TextTransformers.SENTENCE.transform(talent.get(2).get(0));
        final var isActive = TextTransformers.parseBoolean(talent.get(3).get(0));
        return new TalentDescription(description, functions, variable, isActive);
    }

    private List<LavaMathFunc> parseFunctions(@NonNull List<String> data) {
        final var functions = new ArrayList<LavaMathFunc>();
        for (var i = 0; i < MAX_FUNCTIONS; i++) {
            final var function = LavaMathFunc.parse(data, i * 3);
            if (function != null) {
                functions.add(function);
            }
        }
        return functions;
    }

}
