package org.idleon.wiki.tables.customlists2.guildicons;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.guildicons.GuildIconsTable.GuildIcon;

import java.util.List;

public class GuildIconsParser extends DataTableParser<List<List<String>>, GuildIconsTable> {

    public GuildIconsParser() {
        super("scripts.CustomLists2", "GuildIcons");
    }

    @Override
    protected GuildIconsTable parseData(@NonNull List<List<String>> input) {
        return new GuildIconsTable(input.stream().map(this::parseIcons).toList());
    }

    private GuildIcon parseIcons(@NonNull List<String> icons) {
        final var name = TextTransformers.SPACES.transform(icons.get(0));
        final var variants = icons.subList(3, icons.size())
                .stream()
                .map(TextTransformers.SPACES::transform)
                .toList();
        return new GuildIcon(name, variants);
    }

}
