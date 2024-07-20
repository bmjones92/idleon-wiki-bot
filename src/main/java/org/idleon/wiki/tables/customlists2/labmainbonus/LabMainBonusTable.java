package org.idleon.wiki.tables.customlists2.labmainbonus;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.LabMainBonus;

import java.util.Collection;

public class LabMainBonusTable extends ArrayGameTable<LabMainBonus> {

    public LabMainBonusTable(@NonNull Collection<LabMainBonus> items) {
        super(items);
    }

}
