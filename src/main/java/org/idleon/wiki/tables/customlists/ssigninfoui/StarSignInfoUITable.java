package org.idleon.wiki.tables.customlists.ssigninfoui;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class StarSignInfoUITable extends ArrayGameTable<StarSignInfoUITable.StarSignInfo> {

    public StarSignInfoUITable(@NonNull Collection<StarSignInfo> items) {
        super(items);
    }

    public record StarSignInfo(
            int id,
            int x,
            int y,
            int x3,
            int cost
    ) {}

}
