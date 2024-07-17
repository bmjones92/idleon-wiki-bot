package org.idleon.wiki.tables.customlists2.chipdesc;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.ItemQuantityPair;

import java.util.ArrayList;
import java.util.List;

import static org.idleon.wiki.tables.customlists2.chipdesc.ChipDescriptionTable.ChipDescription;

public class ChipDescriptionParser extends DataTableParser<List<List<String>>, ChipDescriptionTable> {

    public ChipDescriptionParser() {
        super("scripts.CustomLists2", "ChipDesc");
    }

    @Override
    protected ChipDescriptionTable parseData(@NonNull List<List<String>> input) {
        return new ChipDescriptionTable(input.stream().map(this::parseChip).toList());
    }

    private ChipDescription parseChip(@NonNull List<String> chip) {
        final var name = TextTransformers.SPACES.transform(chip.get(0));
        final var description = TextTransformers.SPACES.transform(chip.get(1)).replaceAll("\\{", chip.get(11));
        final var shopDescription = TextTransformers.SPACES.transform(chip.get(2));
        final var cost = parseCosts(chip);
        final var isLimitedPerPlayer = TextTransformers.parseBoolean(chip.get(9));
        final var bonusName = chip.get(10);
        return new ChipDescription(name, description, shopDescription, cost, isLimitedPerPlayer, bonusName);
    }

    private List<ItemQuantityPair> parseCosts(@NonNull List<String> chip) {
        final var costs = new ArrayList<ItemQuantityPair>();
        for (var i = 3; i <= 7; i += 2) {
            final var item = chip.get(i);
            final var quantity = Integer.parseInt(chip.get(i + 1));
            costs.add(new ItemQuantityPair(item, quantity));
        }
        return costs;
    }

}
