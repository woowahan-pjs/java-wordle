package com.wodle.service;

import com.wodle.domain.Word;

public class InputMangerProxy extends InputManagerImpl {

    private final ViewManagerImpl viewManager;

    public InputMangerProxy(ViewManagerImpl viewManager) {
        this.viewManager = viewManager;
    }

    @Override
    public Word inputWord() {
        try {
            viewManager.printRequestWordInput();
            return super.inputWord();
        } catch (Exception e) {
            viewManager.notifyInvalidInputWord();
            return this.inputWord();
        }
    }
}
