package org.idleon.wiki.task;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.config.AppConfig;
import org.idleon.wiki.scraper.GameScraper;

public interface Task {

    void execute(@NonNull AppConfig config, @NonNull GameScraper scraper);

}
