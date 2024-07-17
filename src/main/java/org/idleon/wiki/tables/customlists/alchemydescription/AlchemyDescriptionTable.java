package org.idleon.wiki.tables.customlists.alchemydescription;

import org.idleon.wiki.tables.common.ItemQuantityPair;
import org.idleon.wiki.tables.common.LavaMathFunc;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

/**
 * Contains information for alchemy bubbles, vials, and shop items.
 * @param str The list of bubbles in the strength cauldron.
 * @param agi The list of bubbles in the agility cauldron.
 * @param wis The list of bubbles in the wisdom cauldron.
 * @param luk The list of bubbles in the luck cauldron.
 * @param vials The list of vials.
 * @param shop The list of shop items.
 */
public record AlchemyDescriptionTable(
        @NonNull List<AlchemyBubble> str,
        @NonNull List<AlchemyBubble> agi,
        @NonNull List<AlchemyBubble> wis,
        @NonNull List<AlchemyBubble> luk,
        @NonNull List<AlchemyVial> vials,
        @NonNull List<AlchemyShopItem> shop
) implements GameTable {

    /**
     * Describes an alchemy bubble.
     * @param name The name of the bubble.
     * @param func The effect scaling function.
     * @param materials The list of materials required to upgrade this bubble.
     * @param description The human-readable description.
     * @param isEquippable Whether the bubble is a large equippable bubble.
     * @param bonus The internal name for the bonusKey granted by this bubble.
     */
    public record AlchemyBubble(
            @NonNull String name,
            @NonNull LavaMathFunc func,
            @NonNull List<ItemQuantityPair> materials,
            @NonNull String description,
            boolean isEquippable,
            @NonNull String bonus
    ) {}

    /**
     * Describes an alchemy vial.
     * @param name The name of the vial.
     * @param func The effect scaling function.
     * @param ingredients The list of ingredients required to upgrade this vial.
     * @param description The human-readable description of the vial.
     * @param x10 Unknown
     * @param bonus The internal name for the bonusKey granted by this vial.
     */
    public record AlchemyVial(
            @NonNull String name,
            @NonNull LavaMathFunc func,
            @NonNull List<String> ingredients,
            @NonNull String description,
            int x10,
            @NonNull String bonus
    ) {}

    /**
     * Describes an item in the alchemy shop.
     * @param name The name of the item.
     * @param x1
     * @param x2
     * @param x3
     * @param x4
     * @param cost
     * @param description
     * @param x10
     * @param x11
     * @param x12
     * @param x13
     * @param x14
     * @param x15
     * @param x16
     */
    public record AlchemyShopItem(
            @NonNull String name,
            int x1,
            int x2,
            int x3,
            double x4,
            @NonNull List<String> cost,
            @NonNull String description,
            int x10,
            int x11,
            int x12,
            int x13,
            int x14,
            int x15,
            int x16
    ) {}

}
