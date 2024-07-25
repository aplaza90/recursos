package com.recursos.platform.courses.application.create;

import com.recursos.platform.courses.domain.CourseDuration;
import com.recursos.platform.courses.domain.CourseId;
import com.recursos.platform.courses.domain.CourseName;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCourseCommandHandler implements CommandHandler<CreateCourseCommand> {
    private final CourseCreator creator;

    public CreateCourseCommandHandler(CourseCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateCourseCommand command) {

        creator.create(command.id(), command.name(), command.duration());
    }
}
