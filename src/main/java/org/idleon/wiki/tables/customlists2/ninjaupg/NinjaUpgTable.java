package org.idleon.wiki.tables.customlists2.ninjaupg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class NinjaUpgTable extends ArrayGameTable<NinjaUpgTable.NinjaUpg> {

    public NinjaUpgTable(@NonNull Collection<NinjaUpg> items) {
        super(items);
    }

    public record NinjaUpg(
            int x0,
            int x1,
            int x2,
            int x3,
            @NonNull String name,
            int x5,
            @NonNull String description,
            int x7,
            double x8,
            int x9,
            int x,
            int y
    ) {}

}
