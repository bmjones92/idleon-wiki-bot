package org.idleon.wiki.tables.customlists.talenticonnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class TalentIconNamesTable extends ArrayGameTable<String> {

    public TalentIconNamesTable(@NonNull Collection<String> items) {
        super(items);
    }

}
