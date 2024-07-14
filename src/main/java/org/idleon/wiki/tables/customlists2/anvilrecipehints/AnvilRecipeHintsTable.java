package org.idleon.wiki.tables.customlists2.anvilrecipehints;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class AnvilRecipeHintsTable extends ArrayGameTable<List<String>> {

    public AnvilRecipeHintsTable(@NonNull Collection<List<String>> items) {
        super(items);
    }

}
