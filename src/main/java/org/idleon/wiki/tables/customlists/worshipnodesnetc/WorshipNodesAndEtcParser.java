package org.idleon.wiki.tables.customlists.worshipnodesnetc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class WorshipNodesAndEtcParser extends DataTableParser<List<List<List<Integer>>>, WorshipNodesAndEtcTable> {

    public WorshipNodesAndEtcParser() {
        super("scripts.CustomLists", "WorshipNODESnETC");
    }

    @Override
    protected WorshipNodesAndEtcTable parseData(@NonNull List<List<List<Integer>>> input) {
        return new WorshipNodesAndEtcTable(input);
    }

}
