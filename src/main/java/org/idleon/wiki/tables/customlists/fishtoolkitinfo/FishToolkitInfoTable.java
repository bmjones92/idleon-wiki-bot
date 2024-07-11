package org.idleon.wiki.tables.customlists.fishtoolkitinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.GameTable;

import java.util.List;

/**
 * Describes the available fishing toolkits.
 * @param tackle The list of fishing bait and tackle.
 * @param lines The list of fishing lines.
 */
public record FishToolkitInfoTable(
        @NonNull List<FishToolkitInfo> tackle,
        @NonNull List<FishToolkitInfo> lines
) implements GameTable {

    /**
     * Describes a fishing toolkit.
     * @param name The name of the toolkit.
     * @param green The green depth bonus.
     * @param yellow The yellow depth bonus.
     * @param red The red depth bonus.
     * @param purple The purple depth bonus.
     * @param experience The experience bonus.
     * @param speed The fishing speed bonus.
     * @param power The fishing power bonus.
     */
    public record FishToolkitInfo(
            @NonNull String name,
            int green,
            int yellow,
            int red,
            int purple,
            int experience,
            int speed,
            int power
    ) {}

}
