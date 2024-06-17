package wordle.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordle.design.GameManager;

class GameManagerImplTest {

  GameManager gameManager = new GameManagerImpl();


  @BeforeEach
  void setUp(){

  }

  @Test
  void test1(){
    gameManager.start();
  }
}