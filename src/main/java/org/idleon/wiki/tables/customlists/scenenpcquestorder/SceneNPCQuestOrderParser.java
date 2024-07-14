package org.idleon.wiki.tables.customlists.scenenpcquestorder;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class SceneNPCQuestOrderParser extends DataTableParser<List<String>, SceneNPCQuestOrderTable> {

    public SceneNPCQuestOrderParser() {
        super("scripts.CustomLists", "SceneNPCquestOrder");
    }

    @Override
    protected SceneNPCQuestOrderTable parseData(@NonNull List<String> input) {
        return new SceneNPCQuestOrderTable(input);
    }

}
