package org.idleon.wiki.parser.transformer;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Transforms text according to specified rules.
 */
public class TextTransformer {

    /**
     * Regular expression which matches words.
     */
    private static final Pattern WORD_PATTERN = Pattern.compile("\\w+");

    /**
     * Set of punctuation which ends a sentence.
     */
    private static final Set<Character> PUNCTUATION = Set.of('.', '!', '?');

    /**
     * List of words which should not be capitalized when formatting as title case.
     */
    private static final Set<String> TITLE_CASE_EXCEPTIONS = Set.of(
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
    private final Map<Character, Character> replacements;

    /**
     * The casing to apply.
     */
    private final Casing casing;

    /**
     * Creates a new TextTransformer instance.
     * @param builder The builder instance.
     */
    private TextTransformer(@NonNull Builder builder) {
        this.replacements = new HashMap<>(builder.replacements);
        this.casing = builder.casing;
    }

    /**
     * Transformers the specified text according to the rules of this transformer.
     * @param text The text to transform.
     * @return The transformed text.
     */
    public String transform(@NonNull String text) {
        if (!replacements.isEmpty()) {
            for (var entry : replacements.entrySet()) {
                text = text.replace(entry.getKey(), entry.getValue());
            }
            text = text.trim().replaceAll(" +", " ");
        }

        return switch (casing) {
            case UpperCase -> text.toUpperCase();
            case LowerCase -> text.toLowerCase();
            case TitleCase -> text.transform(this::toTitleCase);
            default -> text;
        };
    }

    /**
     * Transforms the text to title case.
     * @param text The text to transform.
     * @return The transformed text.
     */
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
            if ((start == 0) || !TITLE_CASE_EXCEPTIONS.contains(match)) {
                // First word, and any word not explicitly excluded from capitalization should be capitalized.
                chars[start] = Character.toTitleCase(chars[start]);
            } else {
                // Capitalize excluded words which start a sentence.
                for (var i = start; i >= lastMatch; i--) {
                    if (!Character.isWhitespace(chars[i])) {
                        if (PUNCTUATION.contains(chars[i])) {
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

    /**
     * Creates a new Builder instance using this transformer's current settings.
     * @return The builder instance.
     */
    public Builder builder() {
        return new Builder(this);
    }

    /**
     * Creates a new Builder instance.
     * @return The builder instance.
     */
    public static Builder create() {
        return new Builder();
    }

    /**
     * Builds text transformer instances.
     */
    public static class Builder {

        /**
         * The casing to apply to processed text.
         */
        private Casing casing = Casing.Preserve;

        /**
         * The set of character replacements to apply.
         */
        private final Map<Character, Character> replacements = new HashMap<>();

        /**
         * Creates a new builder with default settings.
         */
        private Builder() {}

        /**
         * Creates a new builder with the same initial settings as the specified transformer.
         * @param transformer The transformer.
         */
        private Builder(@NonNull TextTransformer transformer) {
            this.casing = transformer.casing;
            this.replacements.putAll(transformer.replacements);
        }

        /**
         * Specifies the casing to apply to processed values.
         * @param casing The casing to apply
         * @return This builder for chaining.
         */
        public Builder withCasing(@NonNull Casing casing) {
            this.casing = casing;
            return this;
        }

        /**
         * Specifies a set of characters to replace with spaces.
         * @param values The values to replace.
         * @return This builder for chaining.
         */
        public Builder withSpaces(@NonNull Set<Character> values) {
            values.forEach(value -> replacements.put(value, ' '));
            return this;
        }

        public Builder withSpaces(Character... values) {
            return withSpaces(Set.of(values));
        }

        public Builder withNumberPlaceholders(@NonNull Set<Character> values) {
            values.forEach(value -> replacements.put(value, '#'));
            return this;
        }

        public Builder withNumberPlaceholders(Character... values) {
            return withNumberPlaceholders(Set.of(values));
        }

        /**
         * Specifies a set of characters to replace with other characters.
         * @param values The replacement map.
         * @return This builder for chaining.
         */
        public Builder withReplacements(@NonNull Map<Character, Character> values) {
            replacements.putAll(values);
            return this;
        }

        /**
         * Creates a TextTransformer instance using this Builder's current settings.
         * @return The TextTransformer instance.
         */
        public TextTransformer build() {
            return new TextTransformer(this);
        }

    }

}
