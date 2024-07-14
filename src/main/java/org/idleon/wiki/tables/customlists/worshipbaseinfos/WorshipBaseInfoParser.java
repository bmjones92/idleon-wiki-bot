package org.idleon.wiki.tables.customlists.worshipbaseinfos;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.worshipbaseinfos.WorshipBaseInfoTable.WorshipBaseInfo;

import java.util.List;

public class WorshipBaseInfoParser extends DataTableParser<List<List<String>>, WorshipBaseInfoTable> {

    public WorshipBaseInfoParser() {
        super("scripts.CustomLists", "WorshipBASEinfos");
    }

    @Override
    protected WorshipBaseInfoTable parseData(@NonNull List<List<String>> input) {
        return new WorshipBaseInfoTable(input.stream().map(this::parseWorshipBaseInfo).toList());
    }

    private WorshipBaseInfo parseWorshipBaseInfo(@NonNull List<String> info) {
        final var x0 = Integer.parseInt(info.get(0));
        final var x1 = Integer.parseInt(info.get(1));
        final var enemy = info.get(2);
        final var x3 = Integer.parseInt(info.get(3));
        final var x4 = Integer.parseInt(info.get(4));
        final var x5 = Integer.parseInt(info.get(5));
        final var charge = Integer.parseInt(info.get(6));
        final var x7 = Integer.parseInt(info.get(7));
        final var x8 = Integer.parseInt(info.get(8));
        return new WorshipBaseInfo(x0, x1, enemy, x3, x4, x5, charge, x7, x8);
    }

}
