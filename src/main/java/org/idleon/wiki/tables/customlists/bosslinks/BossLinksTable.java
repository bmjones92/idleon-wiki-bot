package org.idleon.wiki.tables.customlists.bosslinks;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class BossLinksTable extends ArrayGameTable<List<Object>> {

    public BossLinksTable(@NonNull Collection<List<Object>> items) {
        super(items);
    }

}
