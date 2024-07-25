package com.recursos.platform.steps.domain.challenge;

import com.recursos.shared.domain.WordMother;

public final class ChallengeStepStatementMother {
    public static ChallengeStepStatement create(String value) {
        return new ChallengeStepStatement(value);
    }

    public static ChallengeStepStatement random() {
        return create(WordMother.random());
    }
}
