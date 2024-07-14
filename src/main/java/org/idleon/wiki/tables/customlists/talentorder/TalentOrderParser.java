package org.idleon.wiki.tables.customlists.talentorder;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class TalentOrderParser extends DataTableParser<List<Integer>, TalentOrderTable> {

    public TalentOrderParser() {
        super("scripts.CustomLists", "TalentOrder");
    }

    @Override
    protected TalentOrderTable parseData(@NonNull List<Integer> input) {
        return new TalentOrderTable(input);
    }

}
