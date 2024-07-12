package org.idleon.wiki.tables.customlists.optionstogglesdata;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.optionstogglesdata.OptionsTogglesDataTable.OptionToggle;

import java.util.List;

public class OptionsTogglesDataParser extends DataTableParser<List<List<Integer>>, OptionsTogglesDataTable> {

    public OptionsTogglesDataParser() {
        super("scripts.CustomLists", "OptionsTogglesData");
    }

    @Override
    protected OptionsTogglesDataTable parseData(@NonNull List<List<Integer>> input) {
        return new OptionsTogglesDataTable(input.stream().map(this::parseOptionToggle).toList());
    }

    private OptionToggle parseOptionToggle(@NonNull List<Integer> input) {
        final var x0 = input.get(0);
        final var x1 = input.get(1);
        final var x2 = input.get(2);
        return new OptionToggle(x0, x1, x2);
    }

}
