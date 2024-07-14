package org.idleon.wiki.tables.customlists.stampdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class StampDescriptionsParser extends DataTableParser<List<List<String>>, StampDescriptionsTable> {

    public StampDescriptionsParser() {
        super("scripts.CustomLists", "StampDescriptions");
    }

    @Override
    protected StampDescriptionsTable parseData(@NonNull List<List<String>> input) {
        return new StampDescriptionsTable(input);
    }

}
