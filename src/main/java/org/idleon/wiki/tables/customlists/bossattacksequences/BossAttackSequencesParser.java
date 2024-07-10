package org.idleon.wiki.tables.customlists.bossattacksequences;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class BossAttackSequencesParser extends DataTableParser<List<List<List<Integer>>>, BossAttackSequencesTable> {

    public BossAttackSequencesParser() {
        super("scripts.CustomLists", "BossAttackSequences");
    }

    @Override
    protected BossAttackSequencesTable parseData(@NonNull List<List<List<Integer>>> input) {
        return new BossAttackSequencesTable(input.getFirst());
    }

}
