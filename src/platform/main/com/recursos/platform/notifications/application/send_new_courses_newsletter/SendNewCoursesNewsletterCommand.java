package com.recursos.platform.notifications.application.send_new_courses_newsletter;

import com.recursos.shared.domain.bus.command.Command;

public final class SendNewCoursesNewsletterCommand implements Command {
    private final String id;

    public SendNewCoursesNewsletterCommand(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
