package org.idleon.wiki.tables.customlists2.dungequipclassreq;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.dungequipclassreq.DungeonEquipClassReqTable.DungeonEquipClassReq;

import java.util.List;

public class DungeonEquipClassReqParser extends DataTableParser<List<List<String>>, DungeonEquipClassReqTable> {

    public DungeonEquipClassReqParser() {
        super("scripts.CustomLists2", "DungEquipClassReq");
    }

    @Override
    protected DungeonEquipClassReqTable parseData(@NonNull List<List<String>> input) {
        return new DungeonEquipClassReqTable(input.stream().map(this::parseEquipClassReq).toList());
    }

    private DungeonEquipClassReq parseEquipClassReq(@NonNull List<String> equip) {
        final var x0 = Integer.parseInt(equip.get(0));
        final var x1 = Integer.parseInt(equip.get(1));
        final var x2 = Integer.parseInt(equip.get(2));
        final var x3 = Integer.parseInt(equip.get(3));
        final var x4 = Integer.parseInt(equip.get(4));
        return new DungeonEquipClassReq(x0, x1, x2, x3, x4);
    }

}
