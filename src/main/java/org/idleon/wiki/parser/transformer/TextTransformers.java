package org.idleon.wiki.parser.transformer;

import org.checkerframework.checker.nullness.qual.NonNull;

public class TextTransformers {

    /**
     * Preset for converting text to a title format.
     */
    public static final TextTransformer TITLE = TextTransformer.create()
            .withSpaces()
            .withCasing(TextTransformer.Casing.TitleCase)
            .build();

    /**
     * Preset for transforming text to a sentence format.
     */
    public static final TextTransformer SENTENCE = TextTransformer.create()
            .withSpaces()
            .withCasing(TextTransformer.Casing.Preserve)
            .build();

    /**
     * Preset for adding spaces to text.
     */
    public static final TextTransformer SPACES = TextTransformer.create()
            .withSpaces()
            .build();

    public static boolean parseBoolean(@NonNull String text) {
        return text.equals("1");
    }

}
