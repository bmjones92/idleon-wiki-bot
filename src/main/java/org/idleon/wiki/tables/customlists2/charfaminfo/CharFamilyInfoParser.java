package org.idleon.wiki.tables.customlists2.charfaminfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.charfaminfo.CharFamilyInfoTable.CharFamilyInfo;

import java.util.List;

public class CharFamilyInfoParser extends DataTableParser<List<List<Integer>>, CharFamilyInfoTable> {

    public CharFamilyInfoParser() {
        super("scripts.CustomLists2", "CharFamInfo");
    }

    @Override
    protected CharFamilyInfoTable parseData(@NonNull List<List<Integer>> input) {
        return new CharFamilyInfoTable(input.stream().map(this::parseCharFarmInfo).toList());
    }

    private CharFamilyInfo parseCharFarmInfo(@NonNull List<Integer> info) {
        final var x0 = info.get(0);
        final var x1 = info.get(1);
        final var x2 = info.get(2);
        if (x0 == 0 && x1 == 0 && x2 == 0) {
            return null;
        }
        return new CharFamilyInfo(x0, x1, x2);
    }

}
