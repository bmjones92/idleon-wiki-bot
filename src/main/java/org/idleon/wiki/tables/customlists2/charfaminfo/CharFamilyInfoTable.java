package org.idleon.wiki.tables.customlists2.charfaminfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class CharFamilyInfoTable extends ArrayGameTable<CharFamilyInfoTable.CharFamilyInfo> {

    public CharFamilyInfoTable(@NonNull Collection<CharFamilyInfo> items) {
        super(items);
    }

    public record CharFamilyInfo(
            int x0,
            int x1,
            int x2
    ) {}

}
