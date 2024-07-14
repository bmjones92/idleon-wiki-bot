package org.idleon.wiki.tables.customlists.tdtraits;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.tdtraits.TowerDefenseTraitsTable.Tower;

import javax.annotation.Nonnull;
import java.util.List;

import static org.idleon.wiki.tables.customlists.tdtraits.TowerDefenseTraitsTable.Trait;

public class TowerDefenseTraitsParser extends DataTableParser<List<List<String>>, TowerDefenseTraitsTable> {

    public TowerDefenseTraitsParser() {
        super("scripts.CustomLists", "TDtraits");
    }

    @Override
    protected TowerDefenseTraitsTable parseData(@NonNull List<List<String>> input) {
        return new TowerDefenseTraitsTable(input.stream().map(this::parseTower).toList());
    }

    private Tower parseTower(@NonNull List<String> tower) {
        final var a = parseTrait(tower.subList(0, 3));
        final var b = parseTrait(tower.subList(3, tower.size()));
        return new Tower(a, b);
    }

    private Trait parseTrait(@NonNull List<String> trait) {
        final var description = parseDescription(trait);
        final var x2 = Integer.parseInt(trait.get(2));
        return new Trait(description, x2);
    }

    private String parseDescription(@Nonnull List<String> trait) {
        return TextTransformers.SPACES.transform(trait.get(0).replaceAll("\\{", trait.get(1)));
    }

}
