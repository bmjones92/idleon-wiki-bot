package org.idleon.wiki.parser.transformer;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.transformer.TextTransformer.Casing;

/**
 * Keeps standard text-transformering
 */
public class TextTransformers {

    /**
     * Preset for adding spaces to text.
     */
    public static final TextTransformer SPACES = TextTransformer.create()
            .withSpaces('_')
            .build();

    /**
     * Preset for converting text to a title format. This should be used for
     */
    public static final TextTransformer TITLE = SPACES.builder()
            .withCasing(Casing.TitleCase)
            .build();

    /**
     * Preset for transforming text to a sentence format.
     */
    public static final TextTransformer SENTENCE = SPACES.builder()
            .withCasing(Casing.Preserve)
            .build();

    /**
     * Parses a boolean from a string. A value of "1" evaluates to true.
     * @param text The text to parse.
     * @return {@code true} if text equals "1", otherwise false.
     */
    public static boolean parseBoolean(@NonNull String text) {
        return text.equals("1");
    }

}
