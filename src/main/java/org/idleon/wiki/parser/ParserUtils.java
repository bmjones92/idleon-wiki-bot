package org.idleon.wiki.parser;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Set;

public class ParserUtils {

    /**
     * The set of values that typically represent empty lines.
     */
    private static final Set<String> STANDARD_BLANK_VALUES = Set.of("Blank", "_", "");

    /**
     * Parses a string as a boolean.
     * @param input The input data.
     * @return {@code true} if input == "1", otherwise {@code false}.
     */
    public static boolean parseBoolean(@NonNull String input) {
        return input.equals("1");
    }

    /**
     * Checks whether the input string is a standard blank value.
     * @param input The input string.
     * @return Whether the value is considered blank.
     */
    public static boolean isBlank(@NonNull String input) {
        return STANDARD_BLANK_VALUES.contains(input);
    }

    /**
     * Checks whether the input string is not a standard blank value.
     * @param input The input string.
     * @return Whether the value is not considered blank.
     */
    public static boolean nonBlank(@NonNull String input) {
        return !isBlank(input);
    }

    /**
     * Hide constructor for utility class.
     */
    private ParserUtils() {}

}
