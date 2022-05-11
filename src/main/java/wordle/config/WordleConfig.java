package wordle.config;


import wordle.app.word.adapter.FindAnswerAdapter;
import wordle.app.word.domain.FileWordsBucket;
import wordle.app.word.domain.WordsBucket;
import wordle.app.game.base.Playable;
import wordle.app.game.wordle.WordleGame;
import wordle.app.match.adapter.MatchWordsAdapter;
import wordle.app.match.application.service.MatchService;
import wordle.app.word.adapter.InputWordsAdapter;
import wordle.app.word.adapter.WordsBucketAdapter;
import wordle.app.word.application.service.WordsService;

import java.time.LocalDate;

public class WordleConfig {

    public Playable wordle() {
        final WordsBucket wordsBucket = new FileWordsBucket("src/main/resources/words.txt", LocalDate.of(2021, 6, 19));
        final WordsService wordsService = wordsService(wordsBucket);
        return new WordleGame(wordsBucketAdapter(wordsService), findAnswerAdapter(wordsService), inputWordsAdapter(wordsService), matchWordsAdapter(matchService()));
    }

    private WordsBucketAdapter wordsBucketAdapter(final WordsService wordsService) {
        return new WordsBucketAdapter(wordsService);
    }

    private FindAnswerAdapter findAnswerAdapter(final WordsService wordsService) {
        return new FindAnswerAdapter(wordsService);
    }

    private WordsService wordsService(final WordsBucket wordsBucket) {
        return new WordsService(wordsBucket);
    }

    private InputWordsAdapter inputWordsAdapter(final WordsService wordsService) {
        return new InputWordsAdapter(wordsService);
    }

    private MatchService matchService() {
        return new MatchService();
    }

    private MatchWordsAdapter matchWordsAdapter(final MatchService matchService) {
        return new MatchWordsAdapter(matchService);
    }

}
