package org.idleon.wiki.tables.customlists.powersuffixes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class PowerSuffixesTable extends ArrayGameTable<String> {

    public PowerSuffixesTable(@NonNull Collection<String> items) {
        super(items);
    }

}
