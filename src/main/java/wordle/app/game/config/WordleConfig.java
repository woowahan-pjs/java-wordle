package wordle.app.game.config;


import wordle.app.game.base.GameConfigurable;
import wordle.app.game.base.GameType;
import wordle.app.word.adapter.in.FindAnswerAdapter;
import wordle.app.word.adapter.out.FileWordsBucket;
import wordle.app.word.application.port.out.WordsBucketPort;
import wordle.app.game.base.Playable;
import wordle.app.game.wordle.WordleGame;
import wordle.app.match.adapter.MatchWordsAdapter;
import wordle.app.match.application.service.MatchService;
import wordle.app.word.adapter.in.InputWordsAdapter;
import wordle.app.word.adapter.in.WordsBucketAdapter;
import wordle.app.word.application.service.WordsService;

import java.time.LocalDate;

class WordleConfig implements GameConfigurable {

    @Override
    public GameType gameType() {
        return GameType.WORDLE;
    }

    @Override
    public Playable game() {
        final WordsBucketPort wordsBucket = new FileWordsBucket("src/main/resources/words.txt", LocalDate.of(2021, 6, 19));
        final WordsService wordsService = wordsService(wordsBucket);
        return new WordleGame(wordsBucketAdapter(wordsService), findAnswerAdapter(wordsService), inputWordsAdapter(wordsService), matchWordsAdapter(matchService()));
    }

    private WordsBucketAdapter wordsBucketAdapter(final WordsService wordsService) {
        return new WordsBucketAdapter(wordsService);
    }

    private FindAnswerAdapter findAnswerAdapter(final WordsService wordsService) {
        return new FindAnswerAdapter(wordsService);
    }

    private WordsService wordsService(final WordsBucketPort wordsBucket) {
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
