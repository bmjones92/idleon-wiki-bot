package org.idleon.wiki.tables.customlists.equipmenttypereq;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class EquipmentTypeReqParser extends DataTableParser<List<List<String>>, EquipmentTypeReqTable> {

    public EquipmentTypeReqParser() {
        super("scripts.CustomLists", "EquipmentTypeReq");
    }

    @Override
    protected EquipmentTypeReqTable parseData(@NonNull List<List<String>> input) {
        final var equipment = input.get(0).subList(0, 8);
        final var specials = input.get(0).subList(8, input.get(0).size());
        final var tools = input.get(1);
        final var food = input.get(2);
        return new EquipmentTypeReqTable(equipment, specials, tools, food);
    }

}