package org.idleon.wiki.tables.customlists.cogmatrices;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class CogMatricesParser extends DataTableParser<List<List<List<Integer>>>, CogMatricesTable> {

    public CogMatricesParser() {
        super("scripts.CustomLists", "CogMatrices");
    }

    @Override
    protected CogMatricesTable parseData(@NonNull List<List<List<Integer>>> input) {
        final var adjacent = parseCog(input.get(0));
        final var diagonal = parseCog(input.get(1));
        final var left = parseCog(input.get(2));
        final var right = parseCog(input.get(3));
        final var down = parseCog(input.get(4));
        final var up = parseCog(input.get(5));
        final var x6 = parseCog(input.get(6));
        final var x7 = parseCog(input.get(7));
        final var corner = parseCog(input.get(8));
        final var x9 = parseCog(input.get(9));
        final var yang = parseCog(input.get(10));
        return new CogMatricesTable(adjacent, diagonal, left, right, down, up, x6, x7, corner, x9, yang);
    }

    private List<CogMatricesTable.Offset> parseCog(@NonNull List<List<Integer>> cog) {
        return cog.stream().map(offset -> new CogMatricesTable.Offset(offset.get(0), offset.get(1))).toList();
    }

}
