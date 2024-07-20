package org.idleon.wiki.tables.customlists2.jadeupg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.jadeupg.JadeUpgTable.JadeUpgrade;

import java.util.List;
import java.util.Objects;

public class JadeUpgParser extends DataTableParser<List<List<String>>, JadeUpgTable> {

    public JadeUpgParser() {
        super("scripts.CustomLists2", "JadeUpg");
    }

    @Override
    protected JadeUpgTable parseData(@NonNull List<List<String>> input) {
        return new JadeUpgTable(input.stream().map(this::parseUpgrade).filter(Objects::nonNull).toList());
    }

    private JadeUpgrade parseUpgrade(@NonNull List<String> upgrade) {
        final var name = TextTransformers.SPACES.transform(upgrade.get(0));
        if (name.equals("IDK YET") || name.equals("UNDER CONSTRUCTION")) {
            return null;
        }

        final var icon = String.format("NjJupg%s.png", Integer.parseInt(upgrade.get(3)));
        final var description = TextTransformers.SPACES.transform(upgrade.get(6));
        return new JadeUpgrade(name, icon, description);
    }

}
