package com.recursos.platform.steps.domain.document;

import com.recursos.platform.steps.domain.Step;
import com.recursos.platform.steps.domain.StepId;
import com.recursos.platform.steps.domain.StepTitle;

import java.util.Objects;

public final class DocumentStep extends Step {
    private final DocumentStepStatement statement;

    public DocumentStep(StepId id, StepTitle title, DocumentStepStatement statement) {
        super(id, title);

        this.statement = statement;
    }

    private DocumentStep() {
        super(null, null);

        this.statement = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        DocumentStep that = (DocumentStep) o;
        return statement.equals(that.statement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), statement);
    }
}
