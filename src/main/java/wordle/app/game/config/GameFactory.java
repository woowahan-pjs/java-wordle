package wordle.app.game.config;


import wordle.app.game.base.GameConfigurable;
import wordle.app.game.base.GameType;
import wordle.app.game.base.Playable;

import java.util.List;
import java.util.NoSuchElementException;

public class GameFactory {

    private final List<GameConfigurable> gameConfigs;

    public GameFactory() {
        this.gameConfigs = List.of(new WordleConfig());
    }

    public Playable gameConfig(final GameType gameType) {
        return gameConfigs.stream()
                .filter(v -> v.gameType() == gameType)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(gameType.toString()))
                .game();
    }

}
