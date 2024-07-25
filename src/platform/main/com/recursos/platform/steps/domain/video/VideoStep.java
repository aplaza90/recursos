package com.recursos.platform.steps.domain.video;

import com.recursos.platform.steps.domain.Step;
import com.recursos.platform.steps.domain.StepId;
import com.recursos.platform.steps.domain.StepTitle;
import com.recursos.shared.domain.VideoUrl;

public final class VideoStep extends Step {
    private final VideoUrl      videoUrl;
    private final VideoStepText text;

    public VideoStep(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
        super(id, title);

        this.videoUrl = videoUrl;
        this.text     = text;
    }

    private VideoStep() {
        super(null, null);

        this.videoUrl = null;
        this.text     = null;
    }
}
