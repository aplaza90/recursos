package com.recursos.platform.steps.domain.challenge;

import com.recursos.platform.steps.domain.StepId;
import com.recursos.platform.steps.domain.StepIdMother;
import com.recursos.platform.steps.domain.StepTitle;
import com.recursos.platform.steps.domain.StepTitleMother;

public final class ChallengeStepMother {
    public static ChallengeStep create(StepId id, StepTitle title, ChallengeStepStatement statement) {
        return new ChallengeStep(id, title, statement);
    }

    public static ChallengeStep random() {
        return create(StepIdMother.random(), StepTitleMother.random(), ChallengeStepStatementMother.random());
    }
}
