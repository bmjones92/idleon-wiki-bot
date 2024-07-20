package org.idleon.wiki.tables.customlists2.jadeupg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class JadeUpgTable extends ArrayGameTable<JadeUpgTable.JadeUpgrade> {

    public JadeUpgTable(@NonNull Collection<JadeUpgrade> items) {
        super(items);
    }

    public record JadeUpgrade(
            @NonNull String name,
            @NonNull String icon,
            @NonNull String description
    ) {}

}
