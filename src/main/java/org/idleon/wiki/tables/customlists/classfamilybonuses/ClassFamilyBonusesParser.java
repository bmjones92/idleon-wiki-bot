package org.idleon.wiki.tables.customlists.classfamilybonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.util.LavaMathFunc;

import java.util.List;

public class ClassFamilyBonusesParser extends DataTableParser<List<List<String>>, ClassFamilyBonusesTable> {

    public ClassFamilyBonusesParser() {
        super("scripts.CustomLists", "ClassFamilyBonuses");
    }

    @Override
    protected ClassFamilyBonusesTable parseData(@NonNull List<List<String>> input) {
        return new ClassFamilyBonusesTable(input.stream().map(bonus -> {
            final var description = TextTransformers.TITLE.transform(bonus.get(0));
            if (description.equals("no family bonus")) {
                return null;
            }

            final var func1 = LavaMathFunc.parse(bonus, 1);
            final var func2 = LavaMathFunc.parse(bonus, 4);

            return new ClassFamilyBonusesTable.ClassFamilyBonus(description, func1, func2);

        }).toList());
    }

}
