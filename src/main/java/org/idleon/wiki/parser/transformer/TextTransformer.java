package org.idleon.wiki.parser.transformer;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Set;
import java.util.regex.Pattern;

public class TextTransformer {

    /**
     * Regular expression which matches words.
     */
    private static final Pattern WORD_PATTERN = Pattern.compile("\\w+");

    /**
     * Set of punctuation which ends a sentence.
     */
    private static final Set<Character> ENDING_PUNCTUATION = Set.of('.', '!', '?');

    /**
     * List of words which should not be capitalized when formatting as title case.
     */
    private static final Set<String> DO_NOT_CAPITALIZE = Set.of(
            "and", "but", "if", "nor", "or", "so", "yet",
            "a", "an", "the",
            "as", "at", "by", "for", "in", "of", "off", "on", "per", "to", "up", "via"
    );

    /**
     * How to format text.
     */
    public enum Casing {
        Preserve,
        UpperCase,
        LowerCase,
        TitleCase
    }

    /**
     * Whether to add spaces.
     */
    private final boolean addSpaces;

    /**
     * The casing to apply.
     */
    private final Casing casing;

    /**
     * Creates a new TextTransformer instance.
     * @param builder The builder instance.
     */
    private TextTransformer(@NonNull Builder builder) {
        this.addSpaces = builder.addSpaces;
        this.casing = builder.casing;
    }

    /**
     * Transformers the specified text according to the rules of this transformer.
     * @param text The text to transform.
     * @return The transformed text.
     */
    public String transform(@NonNull String text) {
        if (addSpaces) {
            // Replace all underscores and vertical pipes with spaces.
            text = text.replaceAll("_", " ");
            // Remove extra spaces.
            text = text.trim().replaceAll(" +", " ");
        }
        return switch (casing) {
            case UpperCase -> text.toUpperCase();
            case LowerCase -> text.toLowerCase();
            case TitleCase -> text.transform(this::toTitleCase);
            default -> text;
        };
    }

    private String toTitleCase(@NonNull String text) {
        text = text.toLowerCase();

        // The array of characters.
        final var chars = text.toCharArray();

        var lastMatch = 0;

        // Iterate over each word and transform it.
        final var matcher = WORD_PATTERN.matcher(text);
        while (matcher.find()) {
            final var start = matcher.start(); // Position starting the match
            final var end = matcher.end();     // Position immediately after the match

            final var match = matcher.group();
            if ((start == 0) || !DO_NOT_CAPITALIZE.contains(match)) {
                // First word, and any word not explicitly excluded from capitalization should be capitalized.
                chars[start] = Character.toTitleCase(chars[start]);
            } else {
                // Capitalize excluded words which start a sentence.
                for (var i = start; i >= lastMatch; i--) {
                    if (!Character.isWhitespace(chars[i])) {
                        if (ENDING_PUNCTUATION.contains(chars[i])) {
                            chars[start] = Character.toTitleCase(chars[start]);
                        }
                        break;
                    }
                }
            }

            lastMatch = end;
        }

        return new String(chars);
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {

        private boolean addSpaces;

        private Casing casing = Casing.Preserve;

        private Builder() {}

        public Builder withSpaces() {
            this.addSpaces = true;
            return this;
        }

        public Builder withCasing(@NonNull Casing casing) {
            this.casing = casing;
            return this;
        }

        public TextTransformer build() {
            return new TextTransformer(this);
        }

    }

}
