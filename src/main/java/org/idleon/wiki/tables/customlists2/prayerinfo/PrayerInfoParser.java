package org.idleon.wiki.tables.customlists2.prayerinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.prayerinfo.PrayerInfoTable.Prayer;

import java.util.List;

public class PrayerInfoParser extends DataTableParser<List<List<String>>, PrayerInfoTable> {

    public PrayerInfoParser() {
        super("scripts.CustomLists2", "PrayerInfo");
    }

    @Override
    protected PrayerInfoTable parseData(@NonNull List<List<String>> input) {
        return new PrayerInfoTable(input.stream().map(this::parsePrayer).toList());
    }

    private Prayer parsePrayer(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        if (name.equals("Some Prayer Name0")) {
            return null;
        }

        final var bonus = parseEffect(input, 0);
        final var curse = parseEffect(input, 1);
        final var encounterId = Integer.parseInt(input.get(5));
        final var costScalar = Integer.parseInt(input.get(6));
        final var unlockWave = Integer.parseInt(input.get(7));
        final var soulId = Integer.parseInt(input.get(8));
        final var maxLevel = Integer.parseInt(input.get(9));
        return new Prayer(name, bonus, curse, encounterId, costScalar, unlockWave, soulId, maxLevel);
    }

    private PrayerInfoTable.PrayerEffect parseEffect(@NonNull List<String> input, int id) {
        final var description = input.get(1 + id);
        final var baseMagnitude = Integer.parseInt(input.get(3 + id));
        return new PrayerInfoTable.PrayerEffect(description, baseMagnitude);
    }

}
