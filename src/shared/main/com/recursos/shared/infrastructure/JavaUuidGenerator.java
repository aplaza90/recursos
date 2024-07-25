package com.recursos.shared.infrastructure;

import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.UuidGenerator;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
