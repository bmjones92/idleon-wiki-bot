package org.idleon.wiki.tables.customlists2.petgenes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;

public class PetGenesTable extends ArrayGameTable<PetGenesTable.PetGene> {

    public PetGenesTable(@NonNull Collection<PetGene> items) {
        super(items);
    }

    public record PetGene(
            @NonNull String name,
            @NonNull String description,
            @NonNull String forageDescription,
            int x1,
            int x2,
            char x3,
            char x4
    ) {}

}
