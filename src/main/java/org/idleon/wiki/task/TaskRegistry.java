package org.idleon.wiki.task;

import io.github.classgraph.ClassInfo;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.registry.Registry;

public class TaskRegistry extends Registry<Task> {

    @Override
    protected boolean shouldProcessCandidate(@NonNull ClassInfo info) {
        return info.implementsInterface(Task.class) && !info.isAbstract();
    }

}
