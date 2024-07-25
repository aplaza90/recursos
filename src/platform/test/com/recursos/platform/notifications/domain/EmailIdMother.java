package com.recursos.platform.notifications.domain;

import com.recursos.shared.domain.UuidMother;

public final class EmailIdMother {
    public static EmailId create(String value) {
        return new EmailId(value);
    }

    public static EmailId random() {
        return create(UuidMother.random());
    }
}
