package org.idleon.wiki.tables.customlists2.traitdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class TraitDescriptionsTable extends ArrayGameTable<String> {

    public TraitDescriptionsTable(@NonNull Collection<String> items) {
        super(items);
    }

}
