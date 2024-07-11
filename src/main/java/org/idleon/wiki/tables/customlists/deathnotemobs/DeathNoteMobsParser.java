package org.idleon.wiki.tables.customlists.deathnotemobs;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class DeathNoteMobsParser extends DataTableParser<List<List<String>>, DeathNoteMobsTable> {

    public DeathNoteMobsParser() {
        super("scripts.CustomLists", "DeathNoteMobs");
    }

    @Override
    protected DeathNoteMobsTable parseData(@NonNull List<List<String>> input) {
        return new DeathNoteMobsTable(input);
    }

}
