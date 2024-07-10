package org.idleon.wiki.tables.customlists.bosslinks;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class BossLinksParser extends DataTableParser<List<List<List<Object>>>, BossLinksTable> {

    public BossLinksParser() {
        super("scripts.CustomLists", "BossLinks");
    }

    @Override
    protected BossLinksTable parseData(@NonNull List<List<List<Object>>> input) {
        return new BossLinksTable(input.getFirst());
    }

}
