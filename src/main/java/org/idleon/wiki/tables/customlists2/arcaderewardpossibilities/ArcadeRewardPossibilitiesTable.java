package org.idleon.wiki.tables.customlists2.arcaderewardpossibilities;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class ArcadeRewardPossibilitiesTable extends ArrayGameTable<List<ArcadeRewardPossibilitiesTable.RewardPossibility>> {

    public ArcadeRewardPossibilitiesTable(@NonNull Collection<List<RewardPossibility>> items) {
        super(items);
    }

    public record RewardPossibility(
            @NonNull String reward,
            boolean scalesWithLevel,
            int quantity,
            double chance
    ) {}

}
