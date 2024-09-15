package com.digitalacademy.monetab.utils;

import com.github.slugify.Slugify;

import java.util.UUID;

public final class SlugGifyUtils {

    private SlugGifyUtils() {
    }

    public static String generateSlug(String value) {

        String text = String.format("%s %s", value, UUID.randomUUID());
        final Slugify slug = Slugify.builder().build();

        return slug.slugify(text);
    }
}
