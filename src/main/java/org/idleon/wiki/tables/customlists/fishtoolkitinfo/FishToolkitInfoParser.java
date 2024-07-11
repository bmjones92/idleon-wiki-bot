package org.idleon.wiki.tables.customlists.fishtoolkitinfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.fishtoolkitinfo.FishToolkitInfoTable.FishToolkitInfo;

import java.util.List;

public class FishToolkitInfoParser extends DataTableParser<List<List<List<String>>>, FishToolkitInfoTable> {

    public FishToolkitInfoParser() {
        super("scripts.CustomLists", "FishToolkitInfo");
    }

    @Override
    protected FishToolkitInfoTable parseData(@NonNull List<List<List<String>>> input) {
        final var tackle = input.get(0).stream().map(this::parseToolkit).toList();
        final var lines = input.get(1).stream().map(this::parseToolkit).toList();
        return new FishToolkitInfoTable(tackle, lines);
    }

    private FishToolkitInfo parseToolkit(@NonNull List<String> toolkit) {
        final var name = TextTransformers.TITLE.transform(toolkit.get(0));
        final var green = Integer.parseInt(toolkit.get(1));
        final var yellow = Integer.parseInt(toolkit.get(2));
        final var red = Integer.parseInt(toolkit.get(3));
        final var purple = Integer.parseInt(toolkit.get(4));
        final var experience = Integer.parseInt(toolkit.get(5));
        final var speed = Integer.parseInt(toolkit.get(6));
        final var power = Integer.parseInt(toolkit.get(7));
        return new FishToolkitInfo(name, green, yellow, red, purple, experience, speed, power);
    }


}
