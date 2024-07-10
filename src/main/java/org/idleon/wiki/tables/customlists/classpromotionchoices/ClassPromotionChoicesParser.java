package org.idleon.wiki.tables.customlists.classpromotionchoices;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ClassPromotionChoicesParser extends DataTableParser<List<List<String>>, ClassPromotionChoicesTable>{

    public ClassPromotionChoicesParser() {
        super("scripts.CustomLists", "ClassPromotionChoices");
    }

    @Override
    protected ClassPromotionChoicesTable parseData(@NonNull List<List<String>> input) {
        return new ClassPromotionChoicesTable(input.stream().map(this::parseChoices).toList());
    }

    private List<Integer> parseChoices(@NonNull List<String> choices) {
        if (choices.size() == 1 && choices.getFirst().equals("Na")) {
            return null;
        }
        return choices.stream().map(Integer::parseInt).toList();
    }

}
