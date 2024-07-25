package com.recursos.platform.steps.domain.document;

import com.recursos.platform.steps.domain.StepId;
import com.recursos.platform.steps.domain.StepIdMother;
import com.recursos.platform.steps.domain.StepTitle;
import com.recursos.platform.steps.domain.StepTitleMother;

public final class DocumentStepMother {
    public static DocumentStep create(StepId id, StepTitle title, DocumentStepStatement statement) {
        return new DocumentStep(id, title, statement);
    }

    public static DocumentStep random() {
        return create(StepIdMother.random(), StepTitleMother.random(), DocumentStepStatementMother.random());
    }
}
