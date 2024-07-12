package org.idleon.wiki.tables.customlists.optionstogglesdata;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class OptionsTogglesDataTable extends ArrayGameTable<OptionsTogglesDataTable.OptionToggle> {

    public OptionsTogglesDataTable(@NonNull Collection<OptionToggle> items) {
        super(items);
    }

    public record OptionToggle(
            int x0,
            int x1,
            int x2
    ) {}

}
