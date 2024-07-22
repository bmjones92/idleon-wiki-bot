package org.idleon.wiki.tables.customlists2.postoffupgradeinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.common.LavaMathFunc;
import org.idleon.wiki.tables.customlists2.postoffupgradeinfo.PostOffUpgradeInfoTable.PostOfficeBonus;
import org.idleon.wiki.tables.customlists2.postoffupgradeinfo.PostOffUpgradeInfoTable.PostOfficeUpgradeInfo;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class PostOffUpgradeInfoParser extends DataTableParser<List<List<String>>, PostOffUpgradeInfoTable> {

    private static final int NUM_BONUSES_PER_BOX = 3;

    private static final int BONUS_FUNC_INDEX = 1;

    private static final int BONUS_DESCRIPTION_INDEX = 4;

    private static final int BONUS_THRESHOLD_INDEX = 13;

    private static final int BONUS_GROUP_INDEX = 16;

    public PostOffUpgradeInfoParser() {
        super("scripts.CustomLists2", "PostOffUpgradeInfo");
    }

    @Override
    protected PostOffUpgradeInfoTable parseData(@NonNull List<List<String>> input) {
        return new PostOffUpgradeInfoTable(input.stream().map(this::parsePostOfficeUpgrade).toList());
    }

    private PostOfficeUpgradeInfo parsePostOfficeUpgrade(@NonNull List<String> input) {
        final var name = TextTransformers.SPACES.transform(input.get(0));
        final var maxPoints = Math.round(Float.parseFloat(input.get(15)));
        final var bonuses = parseBonuses(input);
        return new PostOfficeUpgradeInfo(name, bonuses, maxPoints);
    }

    private List<PostOfficeBonus> parseBonuses(@NonNull List<String> input) {
        final var bonuses = new ArrayList<PostOfficeBonus>();
        for (var i = 0; i < NUM_BONUSES_PER_BOX; i++) {
            bonuses.add(parseBonus(input, i));
        }
        return bonuses;
    }

    private PostOfficeBonus parseBonus(@NonNull List<String> input, int id) {
        final var description = TextTransformers.SPACES.transform(input.get(BONUS_DESCRIPTION_INDEX + id * 4));
        final var func = checkNotNull(LavaMathFunc.parse(input, BONUS_FUNC_INDEX + id * 4));
        final var threshold = id > 0
                ? Math.round(Float.parseFloat(input.get(BONUS_THRESHOLD_INDEX + id - 1)))
                : 0;
        final var bonus = input.get(BONUS_GROUP_INDEX + id);
        return new PostOfficeBonus(description, func, threshold, bonus);
    }

}
