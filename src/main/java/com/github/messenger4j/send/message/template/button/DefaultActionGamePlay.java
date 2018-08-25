package com.github.messenger4j.send.message.template.button;


import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;


/**
 * @author Max Grabenhorst
 * @since 1.0.0
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class DefaultActionGamePlay extends Button {

    private final String payload;

    public static DefaultActionGamePlay create( @NonNull String payload) {
        return new DefaultActionGamePlay(payload);
    }

    private DefaultActionGamePlay(String payload) {
        super(Type.GAME_PLAY);
        this.payload = payload;
    }


    public String payload() {
        return payload;
    }
}