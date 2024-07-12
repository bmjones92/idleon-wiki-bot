package org.idleon.wiki.tables.customlists.postofficepossibleorders;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class PostOfficePossibleOrdersTable extends ArrayGameTable<PostOfficePossibleOrdersTable.Carrier> {

    public PostOfficePossibleOrdersTable(@NonNull Collection<Carrier> items) {
        super(items);
    }

    /**
     * Describes a post office carrier.
     * @param requests The list of possible requests.
     * @param rewards The list of possible rewards.
     * @param unknown Unknown
     */
    public record Carrier(
        @NonNull List<PostOfficeRequest> requests,
        @NonNull List<PostOfficeReward> rewards,
        @NonNull PostOfficeUnknown unknown
    ) {}

    /**
     * Describes a request made by a post office carrier.
     * @param item The name of the requested item.
     * @param baseQuantity The base quantity.
     * @param x2 Unknown, probably some form of scalar.
     */
    public record PostOfficeRequest(
            @NonNull String item,
            int baseQuantity,
            double x2
    ) {}

    public record PostOfficeUnknown(
            int x0,
            int x1,
            int x2,
            int x3,
            int x4
    ) {}

    public record PostOfficeReward(
        @NonNull String item,
        int baseQuantity,
        int x2
    ) {}

}
