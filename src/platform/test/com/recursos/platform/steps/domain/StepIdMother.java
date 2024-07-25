package com.recursos.platform.steps.domain;

import com.recursos.shared.domain.UuidMother;

public final class StepIdMother {
    public static StepId create(String value) {
        return new StepId(value);
    }

    public static StepId random() {
        return create(UuidMother.random());
    }
}
