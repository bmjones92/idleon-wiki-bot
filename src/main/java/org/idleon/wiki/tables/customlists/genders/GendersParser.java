package org.idleon.wiki.tables.customlists.genders;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class GendersParser extends DataTableParser<List<String>, GendersTable> {

    public GendersParser() {
        super("scripts.CustomLists", "Genders");
    }

    @Override
    protected GendersTable parseData(@NonNull List<String> input) {
        return new GendersTable(input);
    }

}
