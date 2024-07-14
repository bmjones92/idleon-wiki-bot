package org.idleon.wiki.tables.customlists.worshipinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.worshipinfo.WorshipInfoTable.WorshipInfo;

import java.util.List;

public class WorshipInfoParser extends DataTableParser<List<List<List<Integer>>>, WorshipInfoTable> {

    public WorshipInfoParser() {
        super("scripts.CustomLists", "WorshipInfo");
    }

    @Override
    protected WorshipInfoTable parseData(@NonNull List<List<List<Integer>>> input) {
        return new WorshipInfoTable(input.stream().map(this::parseWorshipInfoGroup).toList());
    }

    private List<WorshipInfo> parseWorshipInfoGroup(@NonNull List<List<Integer>> info) {
        return info.stream().map(this::parseWorshipInfo).toList();
    }

    private WorshipInfo parseWorshipInfo(@NonNull List<Integer> info) {
        final var x0 = info.get(0);
        final var x1 = info.get(1);
        final var x2 = info.get(2);
        final var x3 = info.get(3);
        return new WorshipInfo(x0, x1, x2, x3);
    }

}
