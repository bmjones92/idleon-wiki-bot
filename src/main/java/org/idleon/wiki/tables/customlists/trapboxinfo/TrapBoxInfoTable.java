package org.idleon.wiki.tables.customlists.trapboxinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class TrapBoxInfoTable extends ArrayGameTable<List<TrapBoxInfoTable.TrapConfiguration>> {

    public TrapBoxInfoTable(@NonNull Collection<List<TrapConfiguration>> items) {
        super(items);
    }

    public record TrapConfiguration(
            int duration,
            int quantity,
            int experience,
            int shiny
    ) {}

}
