package org.idleon.wiki.tables.customlists.newcharlvreq;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class NewCharacterLevelRequirementParser extends DataTableParser<List<Integer>, NewCharacterLevelRequirementTable> {

    public NewCharacterLevelRequirementParser() {
        super("scripts.CustomLists", "NewCharLvReq");
    }

    @Override
    protected NewCharacterLevelRequirementTable parseData(@NonNull List<Integer> input) {
        final var last = input.indexOf(9999);
        return new NewCharacterLevelRequirementTable(input.subList(0, last));
    }

}
