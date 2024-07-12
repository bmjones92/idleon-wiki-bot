package org.idleon.wiki.tables.customlists.scenenpcnodes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.Collections;
import java.util.List;

public class SceneNPCNodesParser extends DataTableParser<List<List<String>>, SceneNPCNodesTable> {

    public SceneNPCNodesParser() {
        super("scripts.CustomLists", "SceneNPCnodes");
    }

    @Override
    protected SceneNPCNodesTable parseData(@NonNull List<List<String>> input) {
        return new SceneNPCNodesTable(input.stream().map(this::parseZone).toList());
    }

    private List<Integer> parseZone(@NonNull List<String> zone) {
        if (zone.get(0).equals("Na")) {
            return Collections.emptyList();
        }
        return zone.stream().map(Integer::parseInt).toList();
    }

}
