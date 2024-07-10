package org.idleon.wiki.tables.customlists.classfamilybonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.util.LavaMathFunc;

import java.util.Collection;

public class ClassFamilyBonusesTable extends ArrayGameTable<ClassFamilyBonusesTable.ClassFamilyBonus> {

    public ClassFamilyBonusesTable(@NonNull Collection<ClassFamilyBonus> items) {
        super(items);
    }

    public record ClassFamilyBonus(
            @NonNull String description,
            @Nullable LavaMathFunc func1,
            @Nullable LavaMathFunc func2
    ) {}

}
