package org.idleon.wiki.tables.common;

import com.google.common.base.Preconditions;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

/**
 * Represents an item name and a quantity.
 * @param item The name of the item.
 * @param quantity The item quantity.
 */
public record ItemQuantityPair(@NonNull String item, int quantity) {

    /**
     * Parses an item quantity pair from the specified list.
     * @param input The input list.
     * @param itemIndex The index of the item value.
     * @param quantityIndex The index of the quantity value.
     * @return The parsed item, or null if it could not be parsed.
     */
    public static ItemQuantityPair parse(@NonNull List<String> input, int itemIndex, int quantityIndex) {
        Preconditions.checkElementIndex(itemIndex, input.size(), "Bad item index");
        Preconditions.checkElementIndex(quantityIndex, input.size(), "Bad quantity index");

        try {
            final var item = input.get(itemIndex);
            final var quantity = Integer.parseInt(input.get(quantityIndex));
            return new ItemQuantityPair(item, quantity);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Parses an item quantity pair from the specified list.
     * @param input The input list.
     * @param startIndex The index of the item name, which should be followed by the quantity index.
     * @return The parsed item, or null if it could not be parsed.
     */
    public static ItemQuantityPair parse(@NonNull List<String> input, int startIndex) {
        return parse(input, startIndex, startIndex + 1);
    }

    /**
     * Parses an item quantity pair from the specified list. The item name should be the first element,
     * and the quantity should be the second element.
     * @param input The input list.
     * @return The parsed item, or null if it could not be parsed.
     */
    public static ItemQuantityPair parse(@NonNull List<String> input) {
        return parse(input, 0);
    }

}
