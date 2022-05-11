package wordle.config;


import wordle.app.bucket.adapter.ContainWordsAdapter;
import wordle.app.bucket.adapter.FindAnswerAdapter;
import wordle.app.bucket.application.service.WordsBucketService;
import wordle.app.bucket.domain.FileWordsBucket;
import wordle.app.bucket.domain.WordsBucket;
import wordle.app.game.base.Playable;
import wordle.app.game.wordle.WordleGame;
import wordle.app.word.adapter.InputWordsAdapter;
import wordle.app.word.adapter.MatchWordsAdapter;
import wordle.app.word.application.service.WordsService;

import java.time.LocalDate;

public class WordleConfig {

    public Playable wordle() {
        final WordsBucket wordsBucket = new FileWordsBucket("src/main/resources/words.txt", LocalDate.of(2021, 6, 19));
        final WordsBucketService wordsBucketService = wordsBucketService(wordsBucket);
        final WordsService wordsService = wordsService();
        return new WordleGame(containWordsAdapter(wordsBucketService), findAnswerAdapter(wordsBucketService), inputWordsAdapter(wordsService), matchWordsAdapter(wordsService));
    }

    private WordsBucketService wordsBucketService(final WordsBucket wordsBucket) {
        return new WordsBucketService(wordsBucket);
    }

    private ContainWordsAdapter containWordsAdapter(final WordsBucketService wordsBucketService) {
        return new ContainWordsAdapter(wordsBucketService);
    }

    private FindAnswerAdapter findAnswerAdapter(final WordsBucketService wordsBucketService) {
        return new FindAnswerAdapter(wordsBucketService);
    }

    private WordsService wordsService() {
        return new WordsService();
    }

    private InputWordsAdapter inputWordsAdapter(final WordsService wordsService) {
        return new InputWordsAdapter(wordsService);
    }

    private MatchWordsAdapter matchWordsAdapter(final WordsService wordsService) {
        return new MatchWordsAdapter(wordsService);
    }

}
