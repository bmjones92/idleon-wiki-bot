package org.idleon.wiki.parser.transformer;

import org.checkerframework.checker.nullness.qual.NonNull;

public class TextTransformer {

    public enum Casing {
        Preserve,
        UpperCase,
        LowerCase,
        TitleCase
    }

    private final boolean addSpaces;

    private final Casing casing;

    private TextTransformer(@NonNull Builder builder) {
        this.addSpaces = builder.addSpaces;
        this.casing = builder.casing;
    }

    public String transform(@NonNull String text) {
        if (addSpaces) {
            text = text.replaceAll("_", " ");
        }
        text = switch (casing) {
            case UpperCase -> text.toUpperCase();
            case LowerCase -> text.toLowerCase();
            default -> text;
        };
        return text;
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
