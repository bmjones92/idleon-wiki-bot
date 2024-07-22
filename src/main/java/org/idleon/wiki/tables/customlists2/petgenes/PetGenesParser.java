package org.idleon.wiki.tables.customlists2.petgenes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.petgenes.PetGenesTable.PetGene;

import java.util.List;
import java.util.Objects;

public class PetGenesParser extends DataTableParser<List<List<String>>, PetGenesTable> {

    public PetGenesParser() {
        super("scripts.CustomLists2", "PetGenes");
    }

    @Override
    protected PetGenesTable parseData(@NonNull List<List<String>> input) {
        return new PetGenesTable(input.stream().map(this::parseGene).filter(Objects::nonNull).toList());
    }

    private PetGene parseGene(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        if (name.equals("GeneName")) {
            return null;
        }

        final var x1 = Integer.parseInt(input.get(1));
        final var x2 = Integer.parseInt(input.get(2));
        final var x3 = input.get(3).charAt(0);
        final var x4 = input.get(4).charAt(0);
        final var description = TextTransformers.SPACES.transform(input.get(5));
        final var forageDescription = TextTransformers.SPACES.transform(input.get(6));
        return new PetGene(name, description, forageDescription, x1, x2, x3, x4);
    }

}
