package org.idleon.wiki.tables.customlists2.postoffupgradeinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.LavaMathFunc;

import java.util.Collection;
import java.util.List;

public class PostOffUpgradeInfoTable extends ArrayGameTable<PostOffUpgradeInfoTable.PostOfficeUpgradeInfo> {

    public PostOffUpgradeInfoTable(@NonNull Collection<PostOfficeUpgradeInfo> items) {
        super(items);
    }

    /**
     * Describes a post office upgrade box.
     * @param name The name of the box.
     * @param bonuses The list of bonuses.
     * @param maxPoints The maximum number of boxes.
     */
    public record PostOfficeUpgradeInfo(
            @NonNull String name,
            @NonNull List<PostOfficeBonus> bonuses,
            int maxPoints
    ) {}

    /**
     * Describes a post office box bonus.
     * @param description The description string.
     * @param func The scaling function.
     * @param threshold The number of points required to unlock this bonus.
     * @param bonusGroup The internal id of the bonus.
     */
    public record PostOfficeBonus(
            @NonNull String description,
            @NonNull LavaMathFunc func,
            int threshold,
            @NonNull String bonusGroup
    ) {}

}
