package org.idleon.wiki.tables.customlists2.guildicons;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class GuildIconsTable extends ArrayGameTable<GuildIconsTable.GuildIcon> {

    public GuildIconsTable(@NonNull Collection<GuildIcon> items) {
        super(items);
    }

    public record GuildIcon(
            @NonNull String category,
            @NonNull List<String> variants
    ) {}

}
