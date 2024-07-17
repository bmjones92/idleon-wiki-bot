package org.idleon.wiki.tables.customlists2.dreamchallenge;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.dreamchallenge.DreamChallengeTable.DreamChallenge;

import java.util.List;

public class DreamChallengeParser extends DataTableParser<List<List<String>>, DreamChallengeTable> {

    public DreamChallengeParser() {
        super("scripts.CustomLists2", "DreamChallenge");
    }

    @Override
    protected DreamChallengeTable parseData(@NonNull List<List<String>> input) {
        return new DreamChallengeTable(input.stream().map(this::parseDreamChallenge).toList());
    }

    private DreamChallenge parseDreamChallenge(@NonNull List<String> challenge) {
        final var description = TextTransformers.SPACES.transform(challenge.get(0));
        final var reward = TextTransformers.SPACES.transform(challenge.get(2));
        return new DreamChallenge(description, reward);
    }

}
