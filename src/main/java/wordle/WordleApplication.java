package wordle;

import wordle.design.GameManager;
import wordle.impl.GameManagerImpl;

public class WordleApplication {

  public static void main(String[] args) {
    GameManager gameManager = new GameManagerImpl();
    gameManager.start();
  }
}
