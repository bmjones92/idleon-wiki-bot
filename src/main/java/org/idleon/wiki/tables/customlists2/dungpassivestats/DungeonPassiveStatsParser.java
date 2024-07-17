package org.idleon.wiki.tables.customlists2.dungpassivestats;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.common.LavaMathFunc;
import org.idleon.wiki.tables.customlists2.dungpassivestats.DungeonPassiveStatsTable.DungeonStat;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class DungeonPassiveStatsParser extends DataTableParser<List<List<String>>, DungeonPassiveStatsTable> {

    public DungeonPassiveStatsParser() {
        super("scripts.CustomLists2", "DungPassiveStats");
    }

    @Override
    protected DungeonPassiveStatsTable parseData(@NonNull List<List<String>> input) {
        return new DungeonPassiveStatsTable(input.stream().map(this::parseStat).toList());
    }

    private DungeonStat parseStat(@NonNull List<String> stat) {
        final var name = stat.get(0).replace('@', ' ');
        final var func = checkNotNull(LavaMathFunc.parse(stat, 1));
        final var x4 = stat.get(4);
        final var bonus = stat.get(5);
        return new DungeonStat(name, func, x4, bonus);
    }

}
