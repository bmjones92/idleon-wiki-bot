package org.idleon.wiki.tables.customlists.equiptypegens;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class EquipTypeGensParser extends DataTableParser<List<List<String>>, EquipTypeGensTable> {

    public EquipTypeGensParser() {
        super("scripts.CustomLists", "EquiptypeGens");
    }

    @Override
    protected EquipTypeGensTable parseData(@NonNull List<List<String>> input) {
        final var x0 = input.get(0);
        final var x1 = input.get(1);
        final var x2 = input.get(2);
        return new EquipTypeGensTable(x0, x1, x2);
    }

}
