package org.idleon.wiki.tables.customlists.coinstrings;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class CoinStringsParser extends DataTableParser<List<String>, CoinStringsTable> {

    public CoinStringsParser() {
        super("scripts.CustomLists", "CoinStrings");
    }

    @Override
    protected CoinStringsTable parseData(@NonNull List<String> input) {
        return new CoinStringsTable(input.stream().map(string -> string.charAt(0)).toList());
    }

}
