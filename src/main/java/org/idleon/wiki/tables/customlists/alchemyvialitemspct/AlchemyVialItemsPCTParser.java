package org.idleon.wiki.tables.customlists.alchemyvialitemspct;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class AlchemyVialItemsPCTParser extends DataTableParser<List<String>, AlchemyVialItemsPCTTable> {

    public AlchemyVialItemsPCTParser() {
        super("scripts.CustomLists", "AlchemyVialItemsPCT");
    }

    @Override
    protected AlchemyVialItemsPCTTable parseData(@NonNull List<String> input) {
        return new AlchemyVialItemsPCTTable(input.stream().map(Integer::parseInt).toList());
    }

}
