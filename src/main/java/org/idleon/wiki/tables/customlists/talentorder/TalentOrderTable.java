package org.idleon.wiki.tables.customlists.talentorder;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class TalentOrderTable extends ArrayGameTable<Integer> {

    public TalentOrderTable(@NonNull Collection<Integer> items) {
        super(items);
    }
    
}
