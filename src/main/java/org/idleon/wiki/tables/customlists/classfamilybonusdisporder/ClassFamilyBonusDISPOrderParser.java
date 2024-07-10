package org.idleon.wiki.tables.customlists.classfamilybonusdisporder;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.List;

public class ClassFamilyBonusDISPOrderParser extends DataTableParser<List<Integer>, ArrayGameTable<Integer>> {

    public ClassFamilyBonusDISPOrderParser() {
        super("scripts.CustomLists", "ClassFamilyBonusDISPorder");
    }

    @Override
    protected ArrayGameTable<Integer> parseData(@NonNull List<Integer> input) {
        return new ArrayGameTable<>(input);
    }

}
