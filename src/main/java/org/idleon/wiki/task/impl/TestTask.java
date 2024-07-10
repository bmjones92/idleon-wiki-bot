package org.idleon.wiki.task.impl;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.config.AppConfig;
import org.idleon.wiki.scraper.GameScraper;
import org.idleon.wiki.task.Task;

public class TestTask implements Task {

    @Override
    public void execute(@NonNull AppConfig config, @NonNull GameScraper scraper) {

    }

}
