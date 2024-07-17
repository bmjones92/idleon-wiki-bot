package org.idleon.wiki.tables.customlists2.atominfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.atominfo.AtomInfoTable.AtomInfo;

import java.util.List;

public class AtomInfoParser extends DataTableParser<List<List<String>>, AtomInfoTable> {

    public AtomInfoParser() {
        super("scripts.CustomLists2", "AtomInfo");
    }

    @Override
    protected AtomInfoTable parseData(@NonNull List<List<String>> input) {
        return new AtomInfoTable(input.stream().map(this::parseAtomInfo).toList());
    }

    private AtomInfo parseAtomInfo(@NonNull List<String> atom) {
        final var name = TextTransformers.SPACES.transform(atom.get(0));
        final var growthFactor = Integer.parseInt(atom.get(1));
        final var baseExponent = Double.parseDouble(atom.get(2));
        final var baseCost = Integer.parseInt(atom.get(3));
        final var bonusPerLevel = Integer.parseInt(atom.get(4));
        final var description = TextTransformers.SPACES.transform(atom.get(5));
        return new AtomInfo(name, growthFactor, baseExponent, baseCost, bonusPerLevel, description);
    }

}