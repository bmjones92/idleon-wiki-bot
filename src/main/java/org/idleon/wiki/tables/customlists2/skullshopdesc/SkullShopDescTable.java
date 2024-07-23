package org.idleon.wiki.tables.customlists2.skullshopdesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class SkullShopDescTable extends ArrayGameTable<SkullShopDescTable.SkullShopItem> {

    public SkullShopDescTable(@NonNull Collection<SkullShopItem> items) {
        super(items);
    }

    /**
     * Describes a skull shop item.
     * @param description The item description.
     * @param cost The skull points cost.
     * @param rewardItem The item to award the player.
     * @param quantity The reward magnitude.
     */
    public record SkullShopItem(
            @NonNull String description,
            int cost,
            @Nullable String rewardItem,
            int quantity
    ) {}

}
