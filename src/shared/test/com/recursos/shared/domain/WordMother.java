package com.recursos.shared.domain;

public final class WordMother {
    public static String random() {
        return MotherCreator.get_random_generator().lorem().word();
    }
}
