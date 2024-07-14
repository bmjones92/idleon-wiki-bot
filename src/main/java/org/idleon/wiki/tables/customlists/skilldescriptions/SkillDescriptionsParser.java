package org.idleon.wiki.tables.customlists.skilldescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;

import java.util.List;
import java.util.Objects;

public class SkillDescriptionsParser extends DataTableParser<List<List<String>>, SkillDescriptionsTable> {

    public SkillDescriptionsParser() {
        super("scripts.CustomLists", "SkillDescriptions");
    }

    @Override
    protected SkillDescriptionsTable parseData(@NonNull List<List<String>> input) {
        return new SkillDescriptionsTable(input.stream().map(this::parseSkill).filter(Objects::nonNull).toList());
    }

    private List<String> parseSkill(@NonNull List<String> skill) {
        return skill.get(0).equals("5") ? null : skill;
    }

}
