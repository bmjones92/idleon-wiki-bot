package org.idleon.wiki.tables.customlists2.artifactinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.artifactinfo.ArtifactInfoTable.ArtifactInfo;
import org.idleon.wiki.tables.customlists2.artifactinfo.ArtifactInfoTable.ArtifactTier;

import java.util.ArrayList;
import java.util.List;

public class ArtifactInfoParser extends DataTableParser<List<List<String>>, ArtifactInfoTable> {

    public ArtifactInfoParser() {
        super("scripts.CustomLists2", "ArtifactInfo");
    }

    @Override
    protected ArtifactInfoTable parseData(@NonNull List<List<String>> input) {
        return new ArtifactInfoTable(input.stream().map(this::parseArtifactInfo).toList());
    }

    private ArtifactInfo parseArtifactInfo(@NonNull List<String> info) {
        final var name = TextTransformers.SPACES.transform(info.get(0));
        final var x1 = Integer.parseInt(info.get(1));
        final var x2 = Integer.parseInt(info.get(2));
        final var x3 = Integer.parseInt(info.get(3));
        final var description = TextTransformers.SPACES.transform(info.get(4));

        final var tiers = new ArrayList<ArtifactTier>();
        for (var i = 5; i < info.size(); i += 2) {
            final var tier = parseArtifactTier(info.subList(i, i + 2));
            tiers.add(tier);
        }
        return new ArtifactInfo(name, x1, x2, x3, description, tiers);
    }

    private ArtifactTier parseArtifactTier(@NonNull List<String> info) {
        final var description = TextTransformers.SPACES.transform(info.get(0));
        final var value = Double.parseDouble(info.get(1));
        return new ArtifactTier(description, value);
    }

}
