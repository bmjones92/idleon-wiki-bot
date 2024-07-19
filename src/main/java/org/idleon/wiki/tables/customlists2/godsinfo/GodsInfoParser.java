package org.idleon.wiki.tables.customlists2.godsinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.godsinfo.GodsInfoTable.GodInfo;

import java.util.List;

public class GodsInfoParser extends DataTableParser<List<List<String>>, GodsInfoTable> {

    public GodsInfoParser() {
        super("scripts.CustomLists2", "GodsInfo");
    }

    @Override
    protected GodsInfoTable parseData(@NonNull List<List<String>> input) {
        return new GodsInfoTable(input.stream().map(this::parseGod).toList());
    }

    private GodInfo parseGod(@NonNull List<String> info) {
        final var name = info.get(0);
        final var linkBonus = TextTransformers.SPACES.transform(info.get(1));
        final var minorLinkBonus = TextTransformers.SPACES.transform(info.get(2)).replace('{', '#');
        final var x3 = Integer.parseInt(info.get(3));
        final var x4 = Integer.parseInt(info.get(4));
        final var x5 = Double.parseDouble(info.get(5));
        final var blessing = TextTransformers.SPACES.transform(info.get(6)).replace('{', '#');
        final var unlockMessage = TextTransformers.SPACES.transform(info.get(7));
        final var x8 = Integer.parseInt(info.get(8));
        final var x9 = Integer.parseInt(info.get(9));
        final var x10 = Integer.parseInt(info.get(10));
        final var x11 = Integer.parseInt(info.get(11));
        final var x12 = Integer.parseInt(info.get(12));
        final var x13 = Integer.parseInt(info.get(13));
        final var x14 = Integer.parseInt(info.get(14));
        return new GodInfo(name, linkBonus, minorLinkBonus, x3, x4, x5, blessing, unlockMessage, x8, x9, x10, x11, x12, x13, x14);
    }

}
