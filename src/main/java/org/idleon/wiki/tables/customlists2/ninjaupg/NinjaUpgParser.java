package org.idleon.wiki.tables.customlists2.ninjaupg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.ninjaupg.NinjaUpgTable.NinjaUpg;

import java.util.List;
import java.util.Set;

public class NinjaUpgParser extends DataTableParser<List<List<String>>, NinjaUpgTable> {

    private static final Set<String> NULL_NAMES = Set.of("_", "Name");

    public NinjaUpgParser() {
        super("scripts.CustomLists2", "NinjaUpg");
    }

    @Override
    protected NinjaUpgTable parseData(@NonNull List<List<String>> input) {
        return new NinjaUpgTable(input.stream().map(this::parseUpgrade).toList());
    }

    private NinjaUpg parseUpgrade(@NonNull List<String> input) {
        if (NULL_NAMES.contains(input.get(4))) {
            return null;
        }

        final var x0 = Integer.parseInt(input.get(0));
        final var x1 = Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var x3 = Integer.parseInt(input.get(3));
        final var name = TextTransformers.SPACES.transform(input.get(4));
        final var x5 = Integer.parseInt(input.get(5));
        final var description = TextTransformers.SPACES.transform(input.get(6));
        final var x7 = Integer.parseInt(input.get(7));
        final var x8 = Double.parseDouble(input.get(8));
        final var x9 = Integer.parseInt(input.get(9));
        final var x = Integer.parseInt(input.get(10));
        final var y = Integer.parseInt(input.get(11));
        return new NinjaUpg(x0, x1, x2, x3, name, x5, description, x7, x8, x9, x, y);
    }

}
