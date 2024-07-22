package org.idleon.wiki.tables.customlists2.patchnotesinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.patchnotesinfo.PatchNotesInfoTable.PatchNotes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PatchNotesInfoParser extends DataTableParser<List<List<String>>, PatchNotesInfoTable> {

    public PatchNotesInfoParser() {
        super("scripts.CustomLists2", "PatchNotesInfo");
    }

    @Override
    protected PatchNotesInfoTable parseData(@NonNull List<List<String>> input) {
        return new PatchNotesInfoTable(input.stream().map(this::parsePatchNotes).toList());
    }

    private PatchNotes parsePatchNotes(@NonNull List<String> input) {
        final var version = input.get(0);
        final var description = parsePatchNotesDescription(input);
        return new PatchNotes(version, description);
    }

    private List<String> parsePatchNotesDescription(@NonNull List<String> input) {
        return Arrays.stream(input.subList(1, input.size()).stream()
                .map(TextTransformers.SPACES::transform)
                .collect(Collectors.joining(" "))
                .split("@"))
                .map(String::trim)
                .toList();
    }

}
