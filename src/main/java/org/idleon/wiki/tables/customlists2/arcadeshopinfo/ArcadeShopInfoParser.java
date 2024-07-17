package org.idleon.wiki.tables.customlists2.arcadeshopinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.arcadeshopinfo.ArcadeShopInfoTable.ArcadeShopInfo;
import org.idleon.wiki.tables.common.LavaMathFunc;

import java.util.List;

import static com.google.common.base.Preconditions.*;

public class ArcadeShopInfoParser extends DataTableParser<List<List<String>>, ArcadeShopInfoTable> {

    public ArcadeShopInfoParser() {
        super("scripts.CustomLists2", "ArcadeShopInfo");
    }

    @Override
    protected ArcadeShopInfoTable parseData(@NonNull List<List<String>> input) {
        return new ArcadeShopInfoTable(input.stream().map(this::parseArcadeShopInfo).toList());
    }

    private ArcadeShopInfo parseArcadeShopInfo(@NonNull List<String> info) {
        final var description = TextTransformers.SPACES.transform(info.get(0));
        final var func = checkNotNull(LavaMathFunc.parse(info, 1));
        final var x4 = info.get(4);
        final var bonus = TextTransformers.SPACES.transform(info.get(5));
        return new ArcadeShopInfo(description, func, x4, bonus);
    }

}
