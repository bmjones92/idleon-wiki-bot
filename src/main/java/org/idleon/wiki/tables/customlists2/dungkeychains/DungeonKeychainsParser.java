package org.idleon.wiki.tables.customlists2.dungkeychains;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.ArrayList;
import java.util.List;

import static org.idleon.wiki.tables.customlists2.dungkeychains.DungeonKeychainsTable.DungeonKeychain;

public class DungeonKeychainsParser extends DataTableParser<List<List<String>>, DungeonKeychainsTable> {

    public DungeonKeychainsParser() {
        super("scripts.CustomLists2", "DungKEYCHAINS");
    }

    @Override
    protected DungeonKeychainsTable parseData(@NonNull List<List<String>> input) {
        return new DungeonKeychainsTable(input.stream().map(this::parseKeychain).toList());
    }

    private DungeonKeychain parseKeychain(@NonNull List<String> keychain) {
        final var id = keychain.get(0);
        final var description = TextTransformers.TITLE.transform(keychain.get(1));
        final var tiers = parseTiers(keychain);
        return new DungeonKeychain(id, description, tiers);
    }

    private List<Double> parseTiers(@NonNull List<String> keychain) {
        final var tiers = new ArrayList<Double>();
        for (var i = 0; i < 3; i++) {
            final var value = Double.parseDouble(keychain.get(i + 2));
            tiers.add(value);
        }
        return tiers;
    }

}
