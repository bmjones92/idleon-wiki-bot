package org.idleon.wiki.tables.customlists.skilllvreqsymbol;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class SkillLvReqSymbolParser extends DataTableParser<List<String>, SkillLvReqSymbolTable> {

    public SkillLvReqSymbolParser() {
        super("scripts.CustomLists", "SkillLvReqSymbol");
    }

    @Override
    protected SkillLvReqSymbolTable parseData(@NonNull List<String> input) {
        return null;
    }

}
