package org.idleon.wiki.tables.customlists.stampbonusindex;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class StampBonusIndexParser extends DataTableParser<List<List<String>>, StampBonusIndexTable> {

    public StampBonusIndexParser() {
        super("scripts.CustomLists", "StampBonusIndex");
    }

    @Override
    protected StampBonusIndexTable parseData(@NonNull List<List<String>> input) {
        return new StampBonusIndexTable(input);
    }

}
