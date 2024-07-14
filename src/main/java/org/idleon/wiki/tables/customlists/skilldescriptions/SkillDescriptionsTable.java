package org.idleon.wiki.tables.customlists.skilldescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class SkillDescriptionsTable extends ArrayGameTable<List<String>> {

    public SkillDescriptionsTable(@NonNull Collection<List<String>> items) {
        super(items);
    }

}
