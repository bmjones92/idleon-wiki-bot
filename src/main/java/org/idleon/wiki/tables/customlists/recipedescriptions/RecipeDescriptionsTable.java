package org.idleon.wiki.tables.customlists.recipedescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class RecipeDescriptionsTable extends ArrayGameTable<String> {

    public RecipeDescriptionsTable(@NonNull Collection<String> items) {
        super(items);
    }

}
