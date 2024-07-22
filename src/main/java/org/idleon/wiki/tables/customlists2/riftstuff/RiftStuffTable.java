package org.idleon.wiki.tables.customlists2.riftstuff;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;
import org.idleon.wiki.tables.common.Coordinate;

import java.util.List;

public record RiftStuffTable(
        @NonNull List<RiftTask> tasks,
        @NonNull List<RiftBonus> bonuses,
        @NonNull List<RiftWave> waves
) implements GameTable {

    public record RiftTask(
            @NonNull String description,
            int quantity,
            int x6
    ) {}

    public record RiftBonus(
            @NonNull String name,
            @NonNull Coordinate position
    ) {}

    public record RiftWave(
            @NonNull String enemy,
            int x3,
            int task
    ) {}

}
