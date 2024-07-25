package com.recursos.platform.notifications.infrastructure;

import com.recursos.platform.notifications.domain.Email;
import com.recursos.platform.notifications.domain.EmailSender;
import com.recursos.shared.domain.Service;

@Service
public final class FakeEmailSender implements EmailSender {
    @Override
    public void send(Email email) {
        // TO-DO
    }
}
