package org.idleon.wiki.tables.customlists.scenenpcquestinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SceneNPCQuestInfoTable extends ArrayGameTable<SceneNPCQuestInfoTable.QuestInfo> {

    public SceneNPCQuestInfoTable(@NonNull Collection<QuestInfo> items) {
        super(items);
    }

    /**
     * Describes the quest info.
     * @param title The title of the quest.
     * @param npc The npc that gives the quest.
     * @param difficulty The difficulty of the quest.
     * @param x3 Unknown - maybe used for quest order?
     */
    public record QuestInfo(
        @NonNull String title,
        @NonNull String npc,
        int difficulty,
        int x3
    ) {}


}
