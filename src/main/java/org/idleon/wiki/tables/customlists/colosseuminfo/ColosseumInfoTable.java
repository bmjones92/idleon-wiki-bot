package org.idleon.wiki.tables.customlists.colosseuminfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class ColosseumInfoTable extends ArrayGameTable<ColosseumInfoTable.ColosseumInfo> {

    public ColosseumInfoTable(@NonNull Collection<ColosseumInfo> items) {
        super(items);
    }

    /**
     * Details for an individual colosseum.
     * @param x0 Unknown
     * @param x1 Unknown
     * @param x2 Unknown
     * @param ticketCost The number of tickets required to enter the colosseum.
     * @param x4 Unknown
     * @param x5 Unknown
     * @param bronzeChestThreshold The point threshold to earn the first bronze chest.
     * @param silverChestThreshold The point threshold to earn the first silver chest.
     * @param goldChestThreshold The point threshold to earn the first gold chest.
     * @param x9 Unknown
     * @param x10 Unknown
     * @param x11 Unknown
     * @param x12 Unknown
     * @param x13 Unknown
     */
    public record ColosseumInfo(
            int x0,
            int x1,
            int x2,
            int ticketCost,
            int x4,
            int x5,
            int bronzeChestThreshold,
            int silverChestThreshold,
            int goldChestThreshold,
            int x9,
            int x10,
            int x11,
            int x12,
            int x13
    ) {}

}
