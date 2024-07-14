package org.idleon.wiki.tables.customlists.trapboxinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.trapboxinfo.TrapBoxInfoTable.TrapConfiguration;

import java.util.List;

public class TrapBoxInfoParser extends DataTableParser<List<List<List<Integer>>>, TrapBoxInfoTable> {

    public TrapBoxInfoParser() {
        super("scripts.CustomLists", "TrapBoxInfo");
    }

    @Override
    protected TrapBoxInfoTable parseData(@NonNull List<List<List<Integer>>> input) {
        return new TrapBoxInfoTable(input.stream().map(this::parseTrapBox).toList());
    }

    private List<TrapConfiguration> parseTrapBox(@NonNull List<List<Integer>> trap) {
        return trap.stream().map(this::parseTrapConfiguration).toList();
    }

    private TrapConfiguration parseTrapConfiguration(@NonNull List<Integer> config) {
        final var duration = config.get(0);
        final var quantity = config.get(1);

        final var isExpMulti = config.get(3) == 1;
        final var experience = isExpMulti ? config.get(2) : 0;
        final var shiny = !isExpMulti ? config.get(2) : 0;

        return new TrapConfiguration(duration, quantity, experience, shiny);
    }

}
