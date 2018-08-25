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
public final class GamePlayButton extends Button {

    private final String title;
    private final String payload;

    public static GamePlayButton create(@NonNull String title, @NonNull String payload) {
        return new GamePlayButton(title, payload);
    }

    private GamePlayButton(String title, String payload) {
        super(Type.GAME_PLAY);
        this.title = title;
        this.payload = payload;
    }

    public String title() {
        return title;
    }

    public String payload() {
        return payload;
    }

}
