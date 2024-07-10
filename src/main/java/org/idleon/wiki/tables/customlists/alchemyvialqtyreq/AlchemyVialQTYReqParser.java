package org.idleon.wiki.tables.customlists.alchemyvialqtyreq;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class AlchemyVialQTYReqParser extends DataTableParser<List<Integer>, AlchemyVialQTYReqTable> {

    public AlchemyVialQTYReqParser() {
        super("scripts.CustomLists", "AlchemyVialQTYreq");
    }

    @Override
    protected AlchemyVialQTYReqTable parseData(@NonNull List<Integer> input) {
        return new AlchemyVialQTYReqTable(input);
    }

}
