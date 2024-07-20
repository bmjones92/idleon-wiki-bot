package org.idleon.wiki.tables.customlists2.dungplatforms;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.dungplatforms.DungeonPlatformsTable.DungeonPlatform;

import java.util.Arrays;
import java.util.List;

public class DungeonPlatformParser extends DataTableParser<List<List<String>>, DungeonPlatformsTable> {

    public DungeonPlatformParser() {
        super("scripts.CustomLists2", "DungPlatforms");
    }

    @Override
    protected DungeonPlatformsTable parseData(@NonNull List<List<String>> input) {
        return new DungeonPlatformsTable(input.stream().map(this::parseDungeonPlatform).toList());
    }

    private DungeonPlatform parseDungeonPlatform(@NonNull List<String> platform) {
        final var x0 = parseList(platform.get(0));
        final var x1 = parseNestedList(platform.get(1));
        final var x2 = parseNestedList(platform.get(2));
        final var x3 = parseNestedList(platform.get(3));
        final var x4 = parseList(platform.get(4));
        final var description = TextTransformers.SPACES.transform(platform.get(5));
        final var x6 = parseList(platform.get(6));
        final var x7 = parseList(platform.get(7));
        return new DungeonPlatform(x0, x1, x2, x3, x4, description, x6, x7);
    }

    private List<Integer> parseList(@NonNull String line) {
        // Some elements include whitespace characters, which JavaScript automatically removes when converting
        // to an integer. We need to manually remove these characters with Java.
        final var tokens = line.replaceAll("\\s", "").split(",");
        return Arrays.stream(tokens).map(Integer::parseInt).toList();
    }

    private List<List<Integer>> parseNestedList(@NonNull String line) {
        return Arrays.stream(line.split(";")).filter(String::isEmpty).map(this::parseList).toList();
    }

}
