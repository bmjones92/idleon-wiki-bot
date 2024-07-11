package org.idleon.wiki.tables.customlists.colosseuminfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ColosseumInfoParser extends DataTableParser<List<List<Integer>>, ColosseumInfoTable> {

    public ColosseumInfoParser() {
        super("scripts.CustomLists", "ColosseumInfo");
    }

    @Override
    protected ColosseumInfoTable parseData(@NonNull List<List<Integer>> input) {
        return null;
    }

}
