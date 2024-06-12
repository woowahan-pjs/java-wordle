package wordle.domain;

interface WordListReader {
    Answer read(final Selector selector);

    WordList read();
}
