package org.idleon.wiki.tables.customlists.queststoreclaim;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class QuestsToReclaimTable extends ArrayGameTable<String> {

    public QuestsToReclaimTable(@NonNull Collection<String> items) {
        super(items);
    }

}
