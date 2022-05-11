package wordle.app.game.base;

public abstract class Game implements Playable {

    @Override
    public void play() {
        init();
        start();
        complete();
    }

    protected void init() {

    }

    protected void start() {

    }

    protected void complete() {

    }

}
