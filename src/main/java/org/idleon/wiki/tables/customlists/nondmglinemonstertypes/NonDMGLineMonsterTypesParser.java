package org.idleon.wiki.tables.customlists.nondmglinemonstertypes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class NonDMGLineMonsterTypesParser extends DataTableParser<List<String>, NonDMGLineMonsterTypesTable> {

    public NonDMGLineMonsterTypesParser() {
        super("scripts.CustomLists", "NonDMGLinemonsterTypes");
    }

    @Override
    protected NonDMGLineMonsterTypesTable parseData(@NonNull List<String> input) {
        return new NonDMGLineMonsterTypesTable(input);
    }

}
