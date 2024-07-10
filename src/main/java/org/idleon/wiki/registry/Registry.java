package org.idleon.wiki.registry;

import io.github.classgraph.ClassInfo;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A registry tracks a set of classes which are loaded and instantiated automatically.
 * @param <T> The type of class stored in this registry.
 * @author Brendan Jones
 */
public abstract class Registry<T> {

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Registry.class);

    /**
     * The class instances managed by this registry.
     */
    private final Map<Class<T>, T> items = new HashMap<>();

    /**
     * Creates a new Registry instance.
     */
    public Registry() {}

    /**
     * Gets the instance of the specified class.
     * @param type The class to get the instance of.
     * @return The instance.
     */
    public T get(@NonNull Class<? extends T> type) {
        final var instance = items.get(type);
        if (instance == null) {
            throw new RuntimeException("Registry does not contain instance of " + type.getName());
        }
        return instance;
    }

    /**
     * Gets an unmodifiable view of the items managed by this registry.
     * @return The list of items.
     */
    public Collection<T> items() {
        return Collections.unmodifiableCollection(items.values());
    }

    /**
     * Processes a candidate class. If accepted, the candidate will be instantiated and registered with this registry.
     * @param info The class info.
     */
    final boolean processCandidate(@NonNull ClassInfo info) {
        // Allow implementation classes to accept or reject the candidate.
        if (!shouldProcessCandidate(info)) {
            return false;
        }

        // Autoloaded classes must have a no-arg constructor.
        final var constructors = info.getDeclaredConstructorInfo().filter(constructor -> constructor.getParameterInfo().length == 0);
        if (constructors.isEmpty()) {
            throw new RuntimeException(String.format("'%s' must have a no-arg constructor.", info.getName()));
        }

        // Instantiate and register the class.
        final var constructor = constructors.getFirst().loadClassAndGetConstructor();
        try {
            @SuppressWarnings("unchecked")
            final var clazz = (Class<T>) constructor.getDeclaringClass();
            @SuppressWarnings("unchecked")
            final var instance = (T) constructor.newInstance();
            items.put(clazz, instance);

            try {
                onItemAdded(info, instance);
            } catch (Exception e) {
                items.remove(clazz);
                throw e;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    /**
     * Checks whether this registry should check the candidate class.
     * @param info The class info.
     * @return {@code true} if this registry should instantiate and register the class.
     */
    protected abstract boolean shouldProcessCandidate(@NonNull ClassInfo info);

    /**
     * Called whenever an item is added to the registry.
     * @param info The class info about the item.
     * @param instance The item that was added.
     */
    protected void onItemAdded(@NonNull ClassInfo info, @NonNull T instance) throws Exception {}

}
