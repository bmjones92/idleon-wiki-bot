package org.idleon.wiki.tables.customlists2.youtubevideos;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class YoutubeVideosTable extends ArrayGameTable<YoutubeVideosTable.YoutubeVideo> {

    public YoutubeVideosTable(@NonNull Collection<YoutubeVideo> items) {
        super(items);
    }

    public record YoutubeVideo(
        @NonNull String title,
        @NonNull String url
    ) {}

}
