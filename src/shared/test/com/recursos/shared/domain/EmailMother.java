package com.recursos.shared.domain;

public final class EmailMother {
    public static String random() {
        return MotherCreator.get_random_generator().internet().emailAddress();
    }
}
