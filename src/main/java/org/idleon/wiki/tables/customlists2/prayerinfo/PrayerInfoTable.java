package org.idleon.wiki.tables.customlists2.prayerinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class PrayerInfoTable extends ArrayGameTable<PrayerInfoTable.Prayer> {

    public PrayerInfoTable(@NonNull Collection<Prayer> items) {
        super(items);
    }

    public record Prayer(
            @NonNull String name,
            @NonNull PrayerEffect bonus,
            @NonNull PrayerEffect curse,
            int encounterId,
            int costScalar,
            int unlockWave,
            int soulId,
            int maxLevel
    ) {}

    public record PrayerEffect(
            @NonNull String description,
            int baseMagnitude
    ) {}

}