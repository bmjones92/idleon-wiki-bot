package org.idleon.wiki.parser;

import io.github.classgraph.ClassInfo;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.registry.Registry;
import org.idleon.wiki.tables.GameTable;

import java.util.HashMap;
import java.util.Map;

public class TableParserRegistry extends Registry<TableParser<?>> {

    private final Map<Class<?>, TableParser<?>> typeToParserMap = new HashMap<>();

    @Override
    protected boolean shouldProcessCandidate(@NonNull ClassInfo info) {
        return info.implementsInterface(TableParser.class) && !info.isAbstract();
    }

    @Override
    protected void onItemAdded(@NonNull ClassInfo info, @NonNull TableParser<?> instance) throws Exception {
        super.onItemAdded(info, instance);

        final var type = instance.getTableClass();
        if (typeToParserMap.putIfAbsent(type, instance) != null) {
            throw new RuntimeException("Duplicate parser found for " + type.getName());
        }
    }

    /**
     * Finds the parser instance for the specified table type if one exists.
     * @param type The table parser type.
     * @return The associated parser.
     * @param <T> The table type.
     */
    public <T extends GameTable> TableParser<T> getParserForTable(@NonNull Class<T> type) {
        @SuppressWarnings("unchecked")
        final var parser = (TableParser<T>) typeToParserMap.get(type);
        return parser;
    }

}
