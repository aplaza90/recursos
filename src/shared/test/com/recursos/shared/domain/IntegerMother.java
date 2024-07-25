package com.recursos.shared.domain;

public final class IntegerMother {
    public static Integer random() {
        return MotherCreator.get_random_generator().number().randomDigit();
    }
}
