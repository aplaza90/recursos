package com.recursos.shared.domain;

import com.github.javafaker.Faker;

public final class MotherCreator {
    private final static Faker faker = new Faker();

    public static Faker get_random_generator() {
        return faker;
    }
}
