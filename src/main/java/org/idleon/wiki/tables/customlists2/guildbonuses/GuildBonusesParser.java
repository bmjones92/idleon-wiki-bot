package org.idleon.wiki.tables.customlists2.guildbonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.LavaMathFunc;
import org.idleon.wiki.tables.customlists2.guildbonuses.GuildBonusesTable.GuildBonus;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class GuildBonusesParser extends DataTableParser<List<List<String>>, GuildBonusesTable> {

    public GuildBonusesParser() {
        super("scripts.CustomLists2", "GuildBonuses");
    }

    @Override
    protected GuildBonusesTable parseData(@NonNull List<List<String>> input) {
        return new GuildBonusesTable(input.stream().map(this::parseBonus).toList());
    }

    private GuildBonus parseBonus(@NonNull List<String> bonus) {
        final var name = TextTransformers.SPACES.transform(bonus.get(0));
        final var x1 = Integer.parseInt(bonus.get(1));
        final var x2 = Integer.parseInt(bonus.get(2));
        final var description = TextTransformers.SPACES.transform(bonus.get(3)).replace('{', '#');
        final var func = checkNotNull(LavaMathFunc.parse(bonus, 4));
        final var x7 = Integer.parseInt(bonus.get(7));
        final var x8 = Integer.parseInt(bonus.get(8));
        final var x9 = Integer.parseInt(bonus.get(9));
        final var x10 = Integer.parseInt(bonus.get(10));
        final var x11 = Integer.parseInt(bonus.get(11));
        return new GuildBonus(name, x1, x2, description, func, x7, x8, x9, x10, x11);
    }

}
