package org.idleon.wiki.tables.customlists.carrycapitemnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class CarryCapItemNamesParser extends DataTableParser<List<List<String>>, CarryCapItemNamesTable> {

    public CarryCapItemNamesParser() {
        super("scripts.CustomLists", "CarryCapItemNames");
    }

    @Override
    protected CarryCapItemNamesTable parseData(@NonNull List<List<String>> input) {
        final var mining = input.get(0);
        final var chopping = input.get(1);
        final var food = input.get(2);
        final var material = input.get(3);
        final var fish = input.get(4);
        final var bug = input.get(5);
        final var critter = input.get(6);
        final var soul = input.get(7);
        return new CarryCapItemNamesTable(mining, chopping, food, material, fish, bug, critter, soul);
    }

}
