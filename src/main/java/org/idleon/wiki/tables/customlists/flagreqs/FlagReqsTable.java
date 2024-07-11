package org.idleon.wiki.tables.customlists.flagreqs;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class FlagReqsTable extends ArrayGameTable<Integer> {

    public FlagReqsTable(@NonNull Collection<Integer> items) {
        super(items);
    }

}
