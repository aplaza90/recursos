package com.recursos.platform.notifications.application.send_new_courses_newsletter;

import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.command.CommandHandler;

@Service
public final class SendNewCoursesNewsletterCommandHandler implements CommandHandler<SendNewCoursesNewsletterCommand> {
    private final NewCoursesNewsletterSender sender;

    public SendNewCoursesNewsletterCommandHandler(NewCoursesNewsletterSender sender) {
        this.sender = sender;
    }

    @Override
    public void handle(SendNewCoursesNewsletterCommand command) {
        sender.send();
    }
}
