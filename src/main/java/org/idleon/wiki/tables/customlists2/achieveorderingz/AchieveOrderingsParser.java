package org.idleon.wiki.tables.customlists2.achieveorderingz;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class AchieveOrderingsParser extends DataTableParser<List<List<Integer>>, AchieveOrderingsTable> {

    public AchieveOrderingsParser() {
        super("scripts.CustomLists2", "AchieveOrderingz");
    }

    @Override
    protected AchieveOrderingsTable parseData(@NonNull List<List<Integer>> input) {
        return new AchieveOrderingsTable(input);
    }

}
