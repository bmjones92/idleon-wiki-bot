package org.idleon.wiki.tables.customlists2.arcaderewardpossibilities;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists2.arcaderewardpossibilities.ArcadeRewardPossibilitiesTable.RewardPossibility;

import java.util.List;

public class ArcadeRewardPossibilitiesParser extends DataTableParser<List<List<List<String>>>, ArcadeRewardPossibilitiesTable> {

    public ArcadeRewardPossibilitiesParser() {
        super("scripts.CustomLists2", "ArcadeRewardPossibilities");
    }

    @Override
    protected ArcadeRewardPossibilitiesTable parseData(@NonNull List<List<List<String>>> input) {
        return new ArcadeRewardPossibilitiesTable(input.stream().map(this::parseBucket).toList());
    }

    private List<RewardPossibility> parseBucket(@NonNull List<List<String>> rewards) {
        return rewards.stream().map(this::parseReward).toList();
    }

    private RewardPossibility parseReward(@NonNull List<String> possibility) {
        final var key = possibility.get(0);
        final var quantityRaw = possibility.get(1);
        final var isVariable = quantityRaw.endsWith("xLV");
        final var quantity = Integer.parseInt(isVariable ? quantityRaw.substring(0, quantityRaw.length() - 3) : quantityRaw);
        final var chance = Double.parseDouble(possibility.get(2));
        return new RewardPossibility(key, isVariable, quantity, chance);
    }

}
