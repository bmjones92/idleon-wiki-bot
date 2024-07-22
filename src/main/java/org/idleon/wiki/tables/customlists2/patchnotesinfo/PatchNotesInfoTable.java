package org.idleon.wiki.tables.customlists2.patchnotesinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;

import java.util.Collection;
import java.util.List;

public class PatchNotesInfoTable extends ArrayGameTable<PatchNotesInfoTable.PatchNotes> {

    public PatchNotesInfoTable(@NonNull Collection<PatchNotes> items) {
        super(items);
    }

    public record PatchNotes(
            @NonNull String version,
            @NonNull List<String> description
    ) {}

}
