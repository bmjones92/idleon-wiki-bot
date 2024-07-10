package org.idleon.wiki.tables.customlists.alchemyvialitems;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class AlchemyVialItemsParser extends DataTableParser<List<String>, AlchemyVialItemsTable> {

    public AlchemyVialItemsParser() {
        super("scripts.CustomLists", "AlchemyVialItems");
    }

    @Override
    protected AlchemyVialItemsTable parseData(@NonNull List<String> input) {
        return new AlchemyVialItemsTable(input);
    }

}
