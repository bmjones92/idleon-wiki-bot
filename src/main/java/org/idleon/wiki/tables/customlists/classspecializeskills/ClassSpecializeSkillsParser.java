package org.idleon.wiki.tables.customlists.classspecializeskills;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;

import java.util.List;

public class ClassSpecializeSkillsParser extends DataTableParser<List<String>, ClassSpecializeSkillsTable> {

    public ClassSpecializeSkillsParser() {
        super("scripts.CustomLists", "ClassSpecializeSkills");
    }

    @Override
    protected ClassSpecializeSkillsTable parseData(@NonNull List<String> input) {
        return new ClassSpecializeSkillsTable(input.stream().map(this::parseEntry).toList());
    }

    private String parseEntry(@NonNull String name) {
        if (name.equals("0") || name.equals("FILLER") || name.equals("_")) {
            return null;
        }
        return TextTransformers.TITLE.transform(name);
    }

}
