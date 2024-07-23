package org.idleon.wiki.tables.customlists.guildgptasks;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

public record GuildGPTasksTable(
        @NonNull List<GuildGPTask> daily,
        @NonNull List<GuildGPTask> weekly
) implements GameTable {

    /**
     * Describes a guild GP task.
     * @param name The human-readable material of the task.
     * @param quantity The number of times the task needs to be completed.
     * @param points The number of GP awarded for completing the task.
     */
    public record GuildGPTask(
            @NonNull String name,
            int quantity,
            int points
    ) {}

}
