package org.idleon.wiki.tables.customlists.newcharlvreq;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class NewCharacterLevelRequirementTable extends ArrayGameTable<Integer> {

    public NewCharacterLevelRequirementTable(@NonNull Collection<Integer> items) {
        super(items);
    }

}
