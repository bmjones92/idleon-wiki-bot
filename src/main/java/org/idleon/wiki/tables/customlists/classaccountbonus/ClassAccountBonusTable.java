package org.idleon.wiki.tables.customlists.classaccountbonus;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class ClassAccountBonusTable extends ArrayGameTable<ClassAccountBonusTable.ClassAccountBonus> {

    public ClassAccountBonusTable(@NonNull Collection<ClassAccountBonus> items) {
        super(items);
    }

    public record ClassAccountBonus(
        @NonNull String description,
        int x1
    ) {}

}
