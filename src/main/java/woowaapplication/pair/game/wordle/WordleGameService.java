package woowaapplication.pair.game.wordle;


import java.util.List;

public class WordleGameService {

    public static final String WORDS_FILE_NAME = "words.txt";

    private final WordleGameStorage wordleGameStorage;

    private final AnswerKeyword answerKeyword;

    private WordleGameService(WordleGameStorage wordleGameStorage, AnswerKeyword answerKeyword) {
        this.wordleGameStorage = wordleGameStorage;
        this.answerKeyword = answerKeyword;
    }

    public static WordleGameService of(WordleGameStorage wordleGameStorage, AnswerKeyword answerKeyword) {
        return new WordleGameService(wordleGameStorage, answerKeyword);
    }

    public boolean isGameOver() {
        return wordleGameStorage.isOutOfChance() || wordleGameStorage.isClear();
    }

    public List<String[]> playRound(String inputKeyword) {
        wordleGameStorage.decreaseChance();
        wordleGameStorage.checkAnswer(inputKeyword, answerKeyword);

        return wordleGameStorage.convertHistoryToEmoji();
    }
}
