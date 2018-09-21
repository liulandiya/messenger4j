package com.github.messenger4j.webhook.event.attachment;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class UnknowAttachment extends Attachment {

    private final Object obj;

    public UnknowAttachment(@NonNull Object obj) {
        this.obj = obj;
    }

    @Override
    public boolean isUnknowAttachment() {
        return true;
    }

    @Override
    public UnknowAttachment asUnknowAttachment() {
        return this;
    }

    public Object value() {
        return obj;
    }
}
