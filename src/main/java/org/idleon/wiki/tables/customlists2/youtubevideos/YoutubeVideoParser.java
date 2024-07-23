package org.idleon.wiki.tables.customlists2.youtubevideos;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

import static org.idleon.wiki.tables.customlists2.youtubevideos.YoutubeVideosTable.YoutubeVideo;

public class YoutubeVideoParser extends DataTableParser<List<List<String>>, YoutubeVideosTable> {

    public YoutubeVideoParser() {
        super("scripts.CustomLists2", "YoutubeVideos");
    }

    @Override
    protected YoutubeVideosTable parseData(@NonNull List<List<String>> input) {
        return new YoutubeVideosTable(input.stream().map(this::parseVideo).toList());
    }

    private YoutubeVideo parseVideo(@NonNull List<String> input) {
        final var title = parseTitle(input);
        final var url = input.get(2);
        return new YoutubeVideo(title, url);
    }

    private String parseTitle(@NonNull List<String> input) {
        return TextTransformers.SPACES.transform(String.join(" ", input.subList(0, 2))).replace(']', '/');
    }

}
