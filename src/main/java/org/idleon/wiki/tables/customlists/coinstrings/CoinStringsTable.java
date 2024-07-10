package org.idleon.wiki.tables.customlists.coinstrings;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class CoinStringsTable extends ArrayGameTable<Character> {

    public CoinStringsTable(@NonNull Collection<Character> items) {
        super(items);
    }

}
