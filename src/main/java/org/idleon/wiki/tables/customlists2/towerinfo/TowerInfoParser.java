package org.idleon.wiki.tables.customlists2.towerinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.ItemQuantityPair;
import org.idleon.wiki.tables.customlists2.towerinfo.TowerInfoTable.TowerInfo;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class TowerInfoParser extends DataTableParser<List<List<String>>, TowerInfoTable> {

    public TowerInfoParser() {
        super("scripts.CustomLists2", "TowerInfo");
    }

    @Override
    protected TowerInfoTable parseData(@NonNull List<List<String>> input) {
        return new TowerInfoTable(input.stream().map(this::parseTower).toList());
    }

    private TowerInfo parseTower(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        final var description = parseDescription(input.get(1));
        final var bonusPerLevel = Double.parseDouble(input.get(2));
        final var x3 = Double.parseDouble(input.get(3));
        final var costs = parseCosts(input);
        final var maxLevel = Integer.parseInt(input.get(8));
        final var x9 = Double.parseDouble(input.get(9));
        final var boostedMaxLevel = Integer.parseInt(input.get(10));
        return new TowerInfo(name, description, bonusPerLevel, x3, costs, maxLevel, x9, boostedMaxLevel);
    }

    private String parseDescription(@NonNull String input) {
        final var index = input.indexOf('@');
        return TextTransformers.SPACES.transform(input.substring(0, index - 1));
    }

    private List<ItemQuantityPair> parseCosts(@NonNull List<String> input) {
        return IntStream.range(0, 2)
                .mapToObj(id -> parseCost(input, id))
                .filter(Objects::nonNull)
                .toList();
    }

    private ItemQuantityPair parseCost(@NonNull List<String> input, int id) {
        final var item = input.get(4 + id);
        if (item.equals("Blank")) {
            return null;
        }
        final var quantity = Integer.parseInt(input.get(6 + id));
        return new ItemQuantityPair(item, quantity);
    }

}
