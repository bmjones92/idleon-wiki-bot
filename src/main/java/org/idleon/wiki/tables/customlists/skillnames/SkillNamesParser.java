package org.idleon.wiki.tables.customlists.skillnames;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;

public class SkillNamesParser extends DataTableParser<List<String>, SkillNamesTable> {

    public SkillNamesParser() {
        super("scripts.CustomLists", "SkillNames");
    }

    @Override
    protected SkillNamesTable parseData(@NonNull List<String> input) {
        return new SkillNamesTable(input.stream().filter(this::isValidSkill).toList());
    }

    private boolean isValidSkill(@NonNull String skill) {
        try {
            Integer.parseInt(skill);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
