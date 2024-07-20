package org.idleon.wiki.tables.customlists2.labmainbonus;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.common.LabMainBonus;

import java.util.List;

public class LabMainBonusParser extends DataTableParser<List<List<String>>, LabMainBonusTable> {

    public LabMainBonusParser() {
        super("scripts.CustomLists2", "LabMainBonus");
    }

    @Override
    protected LabMainBonusTable parseData(@NonNull List<List<String>> input) {
        return new LabMainBonusTable(input.stream().map(LabMainBonus::parse).toList());
    }

}
