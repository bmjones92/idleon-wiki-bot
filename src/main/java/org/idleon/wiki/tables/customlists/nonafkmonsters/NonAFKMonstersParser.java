package org.idleon.wiki.tables.customlists.nonafkmonsters;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class NonAFKMonstersParser extends DataTableParser<List<String>, NonAFKMonstersTable> {

    public NonAFKMonstersParser() {
        super("scripts.CustomLists", "NonAFKmonsters");
    }

    @Override
    protected NonAFKMonstersTable parseData(@NonNull List<String> input) {
        return new NonAFKMonstersTable(input);
    }

}
