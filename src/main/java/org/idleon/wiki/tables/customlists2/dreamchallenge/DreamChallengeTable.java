package org.idleon.wiki.tables.customlists2.dreamchallenge;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class DreamChallengeTable extends ArrayGameTable<DreamChallengeTable.DreamChallenge> {

    public DreamChallengeTable(@NonNull Collection<DreamChallenge> items) {
        super(items);
    }

    public record DreamChallenge(
        @NonNull String description,
        @NonNull String reward
    ) {}

}
