package org.idleon.wiki.tables.customlists.classaccountbonus;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class ClassAccountBonusParser extends DataTableParser<List<List<String>>, ClassAccountBonusTable> {

    public ClassAccountBonusParser() {
        super("scripts.CustomLists", "ClassAccountBonus");
    }

    @Override
    protected ClassAccountBonusTable parseData(@NonNull List<List<String>> input) {
        return new ClassAccountBonusTable(input.stream().map(entry -> {
            final var description = TextTransformers.TITLE.transform(entry.get(0));
            final var x1 = Integer.parseInt(entry.get(1));

            if (description.equals("Z") || description.equals("FILLER")) {
                return null;
            } else {
                return new ClassAccountBonusTable.ClassAccountBonus(description, x1);
            }
        }).toList());
    }

}
