package org.idleon.wiki.util;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public record LavaMathFunc(
        @NonNull LavaMathFuncName name,
        double arg1,
        double arg2
) {

    enum LavaMathFuncName {
        Add,
        BigBase,
        Decay,
        DecayMulti,
        IntervalAdd;

        public static LavaMathFuncName fromString(@NonNull String name) {
            return switch (name) {
                case "add" -> Add;
                case "bigBase" -> BigBase;
                case "decay" -> Decay;
                case "decayMulti" -> DecayMulti;
                case "intervalAdd" -> IntervalAdd;
                default -> throw new IllegalStateException("Unexpected math function: " + name);
            };
        }
    }

    public LavaMathFunc(@NonNull String name, double arg1, double arg2) {
        this(LavaMathFuncName.fromString(name), arg1, arg2);
    }

    /**
     * Parses a lava math function from the arguments starting at index 0. The order of the arguments must be
     * [arg1, arg2, name, ...].
     * @param args The list of arguments.
     * @return The parsed function, or null if an invalid function was provided.
     */
    public static LavaMathFunc parse(@NonNull List<String> args) {
        return parse(args, 0);
    }

    /**
     * Parses a lava math function from the arguments starting from {@code startOffset}. The order of the arguments
     * must be [..., arg1, arg2, name, ...].
     * @param args The list of arguments.
     * @param startOffset The offset of arg1.
     * @return The parsed function, or null if an invalid function was provided.
     */
    public static LavaMathFunc parse(List<String> args, int startOffset) {
        final var name = args.get(startOffset + 2);
        if (name.equals("txt")) {
            return null;
        }
        return new LavaMathFunc(
                name,
                Double.parseDouble(args.get(startOffset)),
                Double.parseDouble(args.get(startOffset + 1))
        );
    }

}
