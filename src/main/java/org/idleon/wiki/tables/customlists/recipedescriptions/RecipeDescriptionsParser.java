package org.idleon.wiki.tables.customlists.recipedescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class RecipeDescriptionsParser extends DataTableParser<List<String>, RecipeDescriptionsTable> {

    public RecipeDescriptionsParser() {
        super("scripts.CustomLists", "RecipeDescriptions");
    }

    @Override
    protected RecipeDescriptionsTable parseData(@NonNull List<String> input) {
        return new RecipeDescriptionsTable(input);
    }
}
