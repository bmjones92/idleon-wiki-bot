package org.idleon.wiki.tables.customlists2.weeklyaction;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

import static com.google.common.base.Preconditions.checkElementIndex;
import static org.idleon.wiki.tables.customlists2.weeklyaction.WeeklyActionTable.ActionType;
import static org.idleon.wiki.tables.customlists2.weeklyaction.WeeklyActionTable.WeeklyAction;

public class WeeklyActionParser extends DataTableParser<List<List<String>>, WeeklyActionTable> {

    public WeeklyActionParser() {
        super("scripts.CustomLists2", "WeeklyACTION");
    }

    @Override
    protected WeeklyActionTable parseData(@NonNull List<List<String>> input) {
        return new WeeklyActionTable(input.stream().map(this::parseAction).toList());
    }

    private WeeklyAction parseAction(@NonNull List<String> input) {
        final var description = parseDescription(input.get(0));
        final var x1 = Double.parseDouble(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var key = input.get(3);
        final var type = parseActionType(input.get(4));
        return new WeeklyAction(description, x1, x2, key, type);
    }

    private String parseDescription(@NonNull String input) {
        final var index = input.indexOf(')');
        return TextTransformers.SPACES.transform(input.substring(index + 2)).replace('{', '#');
    }

    private ActionType parseActionType(@NonNull String input) {
        final var index = checkElementIndex(Integer.parseInt(input), ActionType.values().length);
        return ActionType.values()[index];
    }

}
