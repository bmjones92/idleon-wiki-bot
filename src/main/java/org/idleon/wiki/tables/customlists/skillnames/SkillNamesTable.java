package org.idleon.wiki.tables.customlists.skillnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SkillNamesTable extends ArrayGameTable<String> {

    public SkillNamesTable(@NonNull Collection<String> items) {
        super(items);
    }

}
