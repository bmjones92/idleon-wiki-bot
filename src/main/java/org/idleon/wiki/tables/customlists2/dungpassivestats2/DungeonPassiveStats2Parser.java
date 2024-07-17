package org.idleon.wiki.tables.customlists2.dungpassivestats2;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.common.LavaMathFunc;
import org.idleon.wiki.tables.customlists2.dungpassivestats2.DungeonPassiveStats2Table.DungeonStat2;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class DungeonPassiveStats2Parser extends DataTableParser<List<List<String>>, DungeonPassiveStats2Table> {

    public DungeonPassiveStats2Parser() {
        super("scripts.CustomLists2", "DungPassiveStats2");
    }

    @Override
    protected DungeonPassiveStats2Table parseData(@NonNull List<List<String>> input) {
        return new DungeonPassiveStats2Table(input.stream().map(this::parseStat).toList());
    }

    private DungeonStat2 parseStat(@NonNull List<String> stat) {
        final var name = stat.get(0).replace('@', ' ');
        final var func = checkNotNull(LavaMathFunc.parse(stat, 1));
        final var x4 = stat.get(4);
        final var bonus = stat.get(5);
        return new DungeonStat2(name, func, x4, bonus);
    }

}
