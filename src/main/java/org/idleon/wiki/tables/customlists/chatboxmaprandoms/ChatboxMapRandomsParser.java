package org.idleon.wiki.tables.customlists.chatboxmaprandoms;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class ChatboxMapRandomsParser extends DataTableParser<List<List<String>>, ChatboxMapRandomsTable> {

    public ChatboxMapRandomsParser() {
        super("scripts.CustomLists", "ChatboxMapRandoms");
    }

    @Override
    protected ChatboxMapRandomsTable parseData(@NonNull List<List<String>> input) {
        return new ChatboxMapRandomsTable(input.getFirst().stream().map(TextTransformers.SENTENCE::transform).toList());
    }

}
