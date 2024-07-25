package com.recursos.platform.notifications.application.send_new_courses_newsletter;

import com.recursos.shared.domain.UuidMother;

public final class SendNewCoursesNewsletterCommandMother {
    public static SendNewCoursesNewsletterCommand random() {
        return new SendNewCoursesNewsletterCommand(UuidMother.random());
    }
}
