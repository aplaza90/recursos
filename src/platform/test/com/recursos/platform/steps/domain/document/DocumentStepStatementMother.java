package com.recursos.platform.steps.domain.document;

import com.recursos.shared.domain.WordMother;

public final class DocumentStepStatementMother {
    public static DocumentStepStatement create(String value) {
        return new DocumentStepStatement(value);
    }

    public static DocumentStepStatement random() {
        return create(WordMother.random());
    }
}
