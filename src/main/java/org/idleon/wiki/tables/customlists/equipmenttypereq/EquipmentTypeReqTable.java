package org.idleon.wiki.tables.customlists.equipmenttypereq;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

/**
 * Describes the equipment types for character equip slots.
 * @param equipment The item type that can be slotted into each of the equipment slots.
 * @param specials The item type that can be slotted into each of the special equipment slots.
 * @param tools The item type that can be slotted into each of the tool slots.
 * @param foods The item type that can be slotted into each of the food slots.
 */
public record EquipmentTypeReqTable(
        @NonNull List<String> equipment,
        @NonNull List<String> specials,
        @NonNull List<String> tools,
        @NonNull List<String> foods
) implements GameTable {}
