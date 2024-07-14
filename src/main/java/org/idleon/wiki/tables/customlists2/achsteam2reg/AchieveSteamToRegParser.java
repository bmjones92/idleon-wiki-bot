package org.idleon.wiki.tables.customlists2.achsteam2reg;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class AchieveSteamToRegParser extends DataTableParser<List<Integer>, AchieveSteamToRegTable> {

    public AchieveSteamToRegParser() {
        super("scripts.CustomLists2", "AchSteam2Reg");
    }

    @Override
    protected AchieveSteamToRegTable parseData(@NonNull List<Integer> input) {
        return new AchieveSteamToRegTable(input);
    }

}
