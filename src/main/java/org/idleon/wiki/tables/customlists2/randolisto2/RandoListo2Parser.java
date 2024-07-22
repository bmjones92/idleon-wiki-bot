package org.idleon.wiki.tables.customlists2.randolisto2;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.randolisto2.RandoListo2Table.GamingImport;

import java.util.ArrayList;
import java.util.List;

public class RandoListo2Parser extends DataTableParser<List<List<String>>, RandoListo2Table> {

    public RandoListo2Parser() {
        super("scripts.CustomLists2", "RandoListo2");
    }

    @Override
    protected RandoListo2Table parseData(@NonNull List<List<String>> input) {
        final var mutations = parseMutations(input.get(0));
        final var imports = parseImports(input);
        final var x3 = parseIntegerList(input.get(3));
        final var x6 = parseIntegerList(input.get(6));
        final var x7 = parseIntegerList(input.get(7));
        return new RandoListo2Table(mutations, imports, x3, x6, x7);
    }

    private List<String> parseMutations(@NonNull List<String> input) {
        return input.stream()
                .map(TextTransformers.SPACES::transform)
                .map(text -> text.replace('|', ' '))
                .toList();
    }

    private List<GamingImport> parseImports(@NonNull List<List<String>> input) {
        final var imports = new ArrayList<GamingImport>();
        for (var i = 0; i < input.get(0).size(); i++) {
            imports.add(parseImport(input, i));
        }
        return imports;
    }

    private GamingImport parseImport(@NonNull List<List<String>> input, int id) {
        final var name = TextTransformers.SPACES.transform(input.get(1).get(id));
        if (name.equals("idk")) {
            return null;
        }

        final var flavor = TextTransformers.SPACES.transform(input.get(2).get(id));
        final var description = parseImportDescription(input.get(4).get(id));
        final var effectText = TextTransformers.SPACES.transform(input.get(5).get(id))
                .replace('{', '#');

        return new GamingImport(name, flavor, description, effectText);
    }

    private String parseImportDescription(@NonNull String description) {
        if (description.equals("_")) {
            return null;
        }
        return TextTransformers.SPACES.transform(description).replace('|', ' ');
    }

    private List<Integer> parseIntegerList(@NonNull List<String> input) {
        return input.stream().map(Integer::parseInt).toList();
    }

}
