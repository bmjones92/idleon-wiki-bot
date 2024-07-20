package org.idleon.wiki.tables.customlists2.labmainbonusdesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class LabMainBonusDescParser extends DataTableParser<List<String>, LabMainBonusDescTable> {

    public LabMainBonusDescParser() {
        super("scripts.CustomLists2", "LabMainBonusDESC");
    }

    @Override
    protected LabMainBonusDescTable parseData(@NonNull List<String> input) {
        return new LabMainBonusDescTable(input);
    }

}
