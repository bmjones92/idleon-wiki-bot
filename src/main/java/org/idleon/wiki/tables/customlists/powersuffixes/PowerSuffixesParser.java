package org.idleon.wiki.tables.customlists.powersuffixes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class PowerSuffixesParser extends DataTableParser<List<String>, PowerSuffixesTable> {

    public PowerSuffixesParser() {
        super("scripts.CustomLists", "PowerSuffixes");
    }

    @Override
    protected PowerSuffixesTable parseData(@NonNull List<String> input) {
        return new PowerSuffixesTable(input);
    }

}
