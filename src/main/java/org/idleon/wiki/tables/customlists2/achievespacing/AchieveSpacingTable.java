package org.idleon.wiki.tables.customlists2.achievespacing;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class AchieveSpacingTable extends ArrayGameTable<AchieveSpacingTable.AchieveSpacing> {

    public AchieveSpacingTable(@NonNull Collection<AchieveSpacing> items) {
        super(items);
    }

    public record AchieveSpacing(
            int x0,
            int x1,
            int x2,
            int x3
    ) {}

}
