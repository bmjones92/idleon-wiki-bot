package org.idleon.wiki.tables.customlists2.traitdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class TraitDescriptionsParser extends DataTableParser<List<String>, TraitDescriptionsTable> {

    public TraitDescriptionsParser() {
        super("scripts.CustomLists2", "TraitDescriptions");
    }

    @Override
    protected TraitDescriptionsTable parseData(@NonNull List<String> input) {
        return new TraitDescriptionsTable(input.stream().map(TextTransformers.SPACES::transform).toList());
    }

}
