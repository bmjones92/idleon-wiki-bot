package org.idleon.wiki.tables.customlists.skilldescnumber1;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class SkillDescNumber1Parser extends DataTableParser<List<Integer>, SkillDescNumber1Table> {

    public SkillDescNumber1Parser() {
        super("scripts.CustomLists", "SkillDescNumber1");
    }

    @Override
    protected SkillDescNumber1Table parseData(@NonNull List<Integer> input) {
        return new SkillDescNumber1Table(input);
    }

}
