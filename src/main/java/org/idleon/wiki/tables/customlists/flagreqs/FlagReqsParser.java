package org.idleon.wiki.tables.customlists.flagreqs;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class FlagReqsParser extends DataTableParser<List<Integer>, FlagReqsTable> {

    public FlagReqsParser() {
        super("scripts.CustomLists", "FlagReqs");
    }

    @Override
    protected FlagReqsTable parseData(@NonNull List<Integer> input) {
        return new FlagReqsTable(input);
    }

}
