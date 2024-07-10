package org.idleon.wiki.registry;

import com.google.common.base.Preconditions;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The autoloader class is responsible for automatically loading and instantiating certain classes.
 */
public class Registries {

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Registries.class);

    /**
     * Special registry which tracks other registries.
     */
    private static final Registry<Registry<?>> registries = new Registry<>() {
        @Override
        protected boolean shouldProcessCandidate(@NonNull ClassInfo info) {
            return info.extendsSuperclass(Registry.class) && !info.isAbstract();
        }
    };

    /**
     * Whether the autoloader has already run.
     */
    private static volatile boolean isInitialized;

    /**
     * Initializes registries. This will dynamically find, instantiate, and populate all registries in the game code.
     */
    public static void initialize() {
        Preconditions.checkState(!isInitialized, "Registries is already initialized");
        isInitialized = true;

        final var graph = new ClassGraph()
                .enableMethodInfo()
                .acceptPackages("org.idleon.wiki");

        try (final var result = graph.scan()) {
            instantiateRegistries(result);
            populateRegistries(result);
        }
    }

    /**
     * Automatically discovers and instantiates all registry classes.
     * @param result The scan result to iterate over.
     */
    private static void instantiateRegistries(@NonNull ScanResult result) {
        LOGGER.info("Initializing registries...");
        result.getAllClasses().forEach(info -> {
            if (registries.processCandidate(info)) {
                LOGGER.info("Created registry: {}", info.getSimpleName());
            }
        });
        LOGGER.info("Done initializing registries");
    }

    /**
     * Populates all loaded registries.
     * @param result The scan result to iterate over.
     */
    private static void populateRegistries(@NonNull ScanResult result) {
        LOGGER.info("Populating registries...");
        result.getAllClasses().forEach(info -> registries.items().forEach(registry -> {
            if (registry.processCandidate(info)) {
                LOGGER.info("Added '{}' to '{}'", info.getSimpleName(), registry.getClass().getSimpleName());
            }
        }));
        LOGGER.info("Done populating registries");
    }

    /**
     * Gets the requested registry.
     * @param registryClass The registry type.
     * @return The registry.
     * @param <T> The registry class.
     */
    public static <T extends Registry<?>> T getRegistry(@NonNull Class<T> registryClass) {
        @SuppressWarnings("unchecked")
        final var registry = (T) registries.get(registryClass);
        if (registry == null) {
            throw new RuntimeException(String.format("'%s' is not a valid registry", registryClass.getSimpleName()));
        }
        return registry;
    }

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private Registries() {}

}
