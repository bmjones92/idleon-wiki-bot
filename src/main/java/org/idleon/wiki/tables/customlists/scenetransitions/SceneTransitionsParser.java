package org.idleon.wiki.tables.customlists.scenetransitions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.scenetransitions.SceneTransitionsTable.Portal;

import java.util.List;
import java.util.Set;

public class SceneTransitionsParser extends DataTableParser<List<List<List<String>>>, SceneTransitionsTable> {

    private static final Set<String> NULL_IDS = Set.of("_", "Na", "Z");

    public SceneTransitionsParser() {
        super("scripts.CustomLists", "SceneTransitions");
    }

    @Override
    protected SceneTransitionsTable parseData(@NonNull List<List<List<String>>> input) {
        return new SceneTransitionsTable(input.stream().map(this::parseZone).toList());
    }

    private List<Portal> parseZone(@NonNull List<List<String>> zone) {
        return zone.stream().map(this::parsePortal).toList();
    }

    private Portal parsePortal(@NonNull List<String> zone) {
        if (NULL_IDS.contains(zone.get(0))) {
            return null;
        }

        final var id = Integer.parseInt(zone.get(0));
        final var destination = zone.get(1);
        return new Portal(id, destination);
    }

}
