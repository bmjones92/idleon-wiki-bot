package org.idleon.wiki.tables.customlists2.guildbonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.LavaMathFunc;

import java.util.Collection;

public class GuildBonusesTable extends ArrayGameTable<GuildBonusesTable.GuildBonus> {

    public GuildBonusesTable(@NonNull Collection<GuildBonus> items) {
        super(items);
    }

    public record GuildBonus(
            @NonNull String name,
            int x1,
            int x2,
            @NonNull String description,
            @NonNull LavaMathFunc func,
            int x7,
            int x8,
            int x9,
            int x10,
            int x11
    ) {}

}
