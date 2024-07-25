package com.recursos.shared.domain;

public final class VideoUrlMother {
    public static VideoUrl create(String value) {
        return new VideoUrl(value);
    }

    public static VideoUrl random() {
        return create(MotherCreator.get_random_generator().internet().url());
    }
}
