package com.recursos.platform.steps.domain.video;

import com.recursos.platform.steps.domain.StepId;
import com.recursos.platform.steps.domain.StepIdMother;
import com.recursos.platform.steps.domain.StepTitle;
import com.recursos.platform.steps.domain.StepTitleMother;
import com.recursos.shared.domain.VideoUrl;
import com.recursos.shared.domain.VideoUrlMother;

public final class VideoStepMother {
    public static VideoStep create(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
        return new VideoStep(id, title, videoUrl, text);
    }

    public static VideoStep random() {
        return create(
            StepIdMother.random(),
            StepTitleMother.random(),
            VideoUrlMother.random(),
            VideoStepTextMother.random()
        );
    }
}
