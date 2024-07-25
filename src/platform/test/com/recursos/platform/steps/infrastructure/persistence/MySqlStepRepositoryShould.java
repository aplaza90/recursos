package com.recursos.platform.steps.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import com.recursos.platform.steps.StepsModuleInfrastructureTestCase;
import com.recursos.platform.steps.domain.Step;
import com.recursos.platform.steps.domain.StepIdMother;
import com.recursos.platform.steps.domain.document.DocumentStepMother;
import com.recursos.platform.steps.domain.video.VideoStepMother;

import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlStepRepositoryShould extends StepsModuleInfrastructureTestCase {
    @Test
    void save_a_step() {
        for (Step step : generate_random_steps()) {
            repository.save(step);
        }
    }

    @Test
    void return_an_existing_step() {
        for (Step step : generate_random_steps()) {
            repository.save(step);

            assertEquals(Optional.of(step), repository.search(step.id()));
        }
    }

    @Test
    void not_return_a_non_existing_course() {
        assertFalse(repository.search(StepIdMother.random()).isPresent());
    }

    private List<? extends Step> generate_random_steps() {
        return Arrays.asList(DocumentStepMother.random(), VideoStepMother.random());
    }
}
