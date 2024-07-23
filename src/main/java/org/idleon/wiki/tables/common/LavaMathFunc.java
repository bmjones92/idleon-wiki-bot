package org.idleon.wiki.tables.common;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Set;

/**
 * Represents a math function.
 * @param func The function type.
 * @param arg1 The first function argument.
 * @param arg2 The second function argument.
 */
public record LavaMathFunc(
        @NonNull FuncType func,
        double arg1,
        double arg2
) {

    /**
     * The function type.
     */
    public enum FuncType {
        Add,
        AddLower,
        BigBase,
        BigBaseLower,
        Decay,
        DecayLower,
        DecayMulti,
        DecayMultiLower,
        IntervalAdd,
        IntervalAddLower,
        Reduce,
        ReduceLower,
        PtsSpentOnGuildBonus;

        /**
         * The set of function names which represent "null".
         */
        private static final Set<String> NULL_NAMES = Set.of("_", "txt");

        /**
         * Finds the name which matches the specified string.
         * @param name The specified name.
         * @return The
         */
        public static FuncType fromString(@NonNull String name) {
            if (NULL_NAMES.contains(name)) {
                return null;
            }

            return switch (name) {
                case "add" -> Add;
                case "bigBase" -> BigBase;
                case "decay" -> Decay;
                case "decayMulti" -> DecayMulti;
                case "intervalAdd" -> IntervalAdd;
                case "reduce" -> Reduce;
                default -> throw new IllegalStateException("Unexpected math function: " + name);
            };
        }
    }

    /**
     * Parses a math function from the specified input.
     * @param input The input list.
     * @param nameIndex The index of the function name.
     * @param arg1Index The index of the first argument.
     * @param arg2Index The index of the second argument.
     * @return The function to parse.
     */
    public static LavaMathFunc parse(@NonNull List<String> input, int nameIndex, int arg1Index, int arg2Index) {
        final var func = FuncType.fromString(input.get(nameIndex));
        if (func == null) {
            return null;
        }

        final var x1 = Double.parseDouble(input.get(arg1Index));
        final var x2 = Double.parseDouble(input.get(arg2Index));
        return new LavaMathFunc(func, x1, x2);
    }

    /**
     * Parses a math function from the specified input.
     * @param input The raw input data.
     * @param startIndex The start index of the function definition. Definition must be in the following
     *                   order [arg1, arg2, name].
     * @return The parsed function.
     */
    public static LavaMathFunc parse(@NonNull List<String> input, int startIndex) {
        return parse(input, startIndex + 2, startIndex, startIndex + 1);
    }

    /**
     * Parses a math function from the specified input. The function definition must come at the start
     * of the list in the following order: [arg1, arg2, name].
     * @param input The raw input data.
     * @return The parsed function.
     */
    public static LavaMathFunc parse(@NonNull List<String> input) {
        return parse(input, 0);
    }

}
