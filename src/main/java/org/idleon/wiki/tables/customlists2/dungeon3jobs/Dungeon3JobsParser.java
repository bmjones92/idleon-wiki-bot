package org.idleon.wiki.tables.customlists2.dungeon3jobs;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists2.dungeon3jobs.Dungeon3JobsTable.DungeonJob;

import java.util.List;

public class Dungeon3JobsParser extends DataTableParser<List<List<String>>, Dungeon3JobsTable> {

    public Dungeon3JobsParser() {
        super("scripts.CustomLists2", "Dungeon3Jobs");
    }

    @Override
    protected Dungeon3JobsTable parseData(@NonNull List<List<String>> input) {
        return new Dungeon3JobsTable(input.stream().map(this::parseJob).toList());
    }

    private DungeonJob parseJob(@NonNull List<String> job) {
        final var description = TextTransformers.SPACES.transform(job.get(0).replaceAll("_\\{s_left.", ""));
        final var x1 = Integer.parseInt(job.get(1));
        final var x2 = Integer.parseInt(job.get(2));
        final var x3 = TextTransformers.parseBoolean(job.get(3));
        return new DungeonJob(description, x1, x2, x3);
    }

}
