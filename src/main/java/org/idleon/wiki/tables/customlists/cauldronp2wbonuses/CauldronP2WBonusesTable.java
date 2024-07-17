package org.idleon.wiki.tables.customlists.cauldronp2wbonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;
import org.idleon.wiki.tables.common.LavaMathFunc;

public record CauldronP2WBonusesTable(
        @NonNull Cauldrons cauldrons,
        @NonNull Liquids liquids,
        @NonNull Vials vials,
        @NonNull Player player
) implements GameTable {

    public record Cauldrons(
            @NonNull LavaMathFunc speed,
            @NonNull LavaMathFunc newBubble,
            @NonNull LavaMathFunc boostReq
    ) {}

    public record Liquids(
            @NonNull LavaMathFunc regenRate,
            @NonNull LavaMathFunc capacity
    ) {}

    public record Vials(
            @NonNull LavaMathFunc attempts,
            @NonNull LavaMathFunc rng
    ) {}

    public record Player(
            @NonNull LavaMathFunc speed,
            @NonNull LavaMathFunc extraExp
    ) {}

}
