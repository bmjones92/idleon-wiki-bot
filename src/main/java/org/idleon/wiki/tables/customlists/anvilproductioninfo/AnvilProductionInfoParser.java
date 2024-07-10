package org.idleon.wiki.tables.customlists.anvilproductioninfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

import static org.idleon.wiki.tables.customlists.anvilproductioninfo.AnvilProductionInfoTable.AnvilProductionItem;

public class AnvilProductionInfoParser extends DataTableParser<List<List<String>>, AnvilProductionInfoTable> {

    public AnvilProductionInfoParser() {
        super("scripts.CustomLists", "AnvilProductionInfo");
    }

    @Override
    protected AnvilProductionInfoTable parseData(@NonNull List<List<String>> input) {
        return new AnvilProductionInfoTable(input.stream().map(item -> {
            final var name = item.get(0);
            final var work = Integer.parseInt(item.get(1));
            final var level = Integer.parseInt(item.get(2));
            final var experience = Integer.parseInt(item.get(3));
            return new AnvilProductionItem(name, work, level, experience);
        }).toList());
    }

}
