package com.wodle.controller;

import com.wodle.service.GameService;
import com.wodle.backend.InputManagerImpl;
import com.wodle.ui.ViewManager;
import com.wodle.backend.WordGenerator;

public class GameHost {

    private final GameService gameService;
    public GameHost(InputManagerImpl inputManagerProxy, ViewManager viewManager,
        WordGenerator wordGenerator) {
        this.gameService = new GameService(
            wordGenerator, viewManager, inputManagerProxy
        );
    }

    public void play() {
        gameService.play();
    }

}
