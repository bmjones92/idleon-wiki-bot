package org.idleon.wiki.tables.customlists.scenetransitions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class SceneTransitionsTable extends ArrayGameTable<List<SceneTransitionsTable.Portal>> {

    public SceneTransitionsTable(@NonNull Collection<List<Portal>> items) {
        super(items);
    }

    public record Portal(
            int id,
            @NonNull String destination
    ) {}

}
