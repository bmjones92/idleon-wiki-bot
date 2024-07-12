package org.idleon.wiki.tables.customlists.obolshapes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class ObolShapesParser extends DataTableParser<List<String>, ObolShapesTable> {

    public ObolShapesParser() {
        super("scripts.CustomLists", "ObolShapes");
    }

    @Override
    protected ObolShapesTable parseData(@NonNull List<String> input) {
        return new ObolShapesTable(input);
    }

}
