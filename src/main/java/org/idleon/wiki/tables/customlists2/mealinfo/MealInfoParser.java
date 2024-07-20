package org.idleon.wiki.tables.customlists2.mealinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

import static org.idleon.wiki.tables.customlists2.mealinfo.MealInfoTable.MealInfo;

public class MealInfoParser extends DataTableParser<List<List<String>>, MealInfoTable> {

    public MealInfoParser() {
        super("scripts.CustomLists2", "MealINFO");
    }

    @Override
    protected MealInfoTable parseData(@NonNull List<List<String>> input) {
        return new MealInfoTable(input.stream().map(this::parseMeal).toList());
    }

    private MealInfo parseMeal(@NonNull List<String> info) {
        final var name = TextTransformers.SPACES.transform(info.get(0));
        final var work = Long.parseLong(info.get(1));
        final var x2 = Integer.parseInt(info.get(2));
        final var description = TextTransformers.SPACES.transform(info.get(3)).replace('{', '#');
        final var flavorText = TextTransformers.SPACES.transform(info.get(4));
        final var bonus = info.get(5);
        return new MealInfo(name, work, x2, description, flavorText, bonus);
    }

}
