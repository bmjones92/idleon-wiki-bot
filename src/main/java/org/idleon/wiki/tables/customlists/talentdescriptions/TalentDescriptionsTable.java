package org.idleon.wiki.tables.customlists.talentdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.LavaMathFunc;

import java.util.Collection;
import java.util.List;

public class TalentDescriptionsTable extends ArrayGameTable<TalentDescriptionsTable.TalentDescription> {

    public TalentDescriptionsTable(@NonNull Collection<TalentDescription> items) {
        super(items);
    }

    public record TalentDescription(
            @NonNull String description,
            @NonNull List<LavaMathFunc> functions,
            @NonNull String variable,
            boolean isActive
    ) {}

}
