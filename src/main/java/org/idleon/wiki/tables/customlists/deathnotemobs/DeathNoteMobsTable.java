package org.idleon.wiki.tables.customlists.deathnotemobs;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class DeathNoteMobsTable extends ArrayGameTable<List<String>> {

    public DeathNoteMobsTable(@NonNull Collection<List<String>> items) {
        super(items);
    }

}
