package org.idleon.wiki.tables.customlists.scenenpcquestinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.scenenpcquestinfo.SceneNPCQuestInfoTable.QuestInfo;

import java.util.List;

public class SceneNPCQuestInfoParser extends DataTableParser<List<List<String>>, SceneNPCQuestInfoTable> {

    public SceneNPCQuestInfoParser() {
        super("scripts.CustomLists", "SceneNPCquestInfo");
    }

    @Override
    protected SceneNPCQuestInfoTable parseData(@NonNull List<List<String>> input) {
        return new SceneNPCQuestInfoTable(input.stream().map(this::parseQuest).toList());
    }

    private QuestInfo parseQuest(@NonNull List<String> quest) {
        final var title = TextTransformers.SPACES.transform(quest.get(0));
        final var npc = TextTransformers.SPACES.transform(quest.get(1));
        if (title.equals("f") && npc.equals("f")) {
            return null;
        }

        // The "Rhyming is Key" quest has a typo in the difficulty. Handle that here.
        final var difficulty = quest.get(2).equals("4f") ? 4 : Integer.parseInt(quest.get(2));
        final var x3 = Integer.parseInt(quest.get(3));
        return new QuestInfo(title, npc, difficulty, x3);
    }

}
