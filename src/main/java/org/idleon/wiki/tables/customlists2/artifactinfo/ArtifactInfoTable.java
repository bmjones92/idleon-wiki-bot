package org.idleon.wiki.tables.customlists2.artifactinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class ArtifactInfoTable extends ArrayGameTable<ArtifactInfoTable.ArtifactInfo> {

    public ArtifactInfoTable(@NonNull Collection<ArtifactInfo> items) {
        super(items);
    }

    public record ArtifactInfo(
            @NonNull String title,
            int x1,
            int x2,
            int x3,
            @NonNull String description,
            @NonNull List<ArtifactTier> tiers
    ) {}

    public record ArtifactTier(
            @NonNull String description,
            double scalar
    ) {}

}
