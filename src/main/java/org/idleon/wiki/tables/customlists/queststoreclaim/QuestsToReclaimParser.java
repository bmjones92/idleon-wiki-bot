package org.idleon.wiki.tables.customlists.queststoreclaim;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class QuestsToReclaimParser extends DataTableParser<List<String>, QuestsToReclaimTable> {

    public QuestsToReclaimParser() {
        super("scripts.CustomLists", "QuestsToRECLAIM");
    }

    @Override
    protected QuestsToReclaimTable parseData(@NonNull List<String> input) {
        return new QuestsToReclaimTable(input);
    }

}
