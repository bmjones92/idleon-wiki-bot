package org.idleon.wiki.tables.customlists2.dungequipclassreq;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class DungeonEquipClassReqTable extends ArrayGameTable<DungeonEquipClassReqTable.DungeonEquipClassReq> {

    public DungeonEquipClassReqTable(@NonNull Collection<DungeonEquipClassReq> items) {
        super(items);
    }

    public record DungeonEquipClassReq(
            int x0,
            int x1,
            int x2,
            int x3,
            int x4
    ) {}

}
