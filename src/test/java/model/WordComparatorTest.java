package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordComparatorTest {
    private WordComparator wordComparator = new WordComparator();

    @Test
    @DisplayName("getPerfectMatchedIndex()에서 모든 글자가 일치할 경우 단어의 전체 인덱스를 반환한다.")
    void fullyMatch_getPerfectMatchedIndex() {

        List<Integer> perfect = wordComparator.getPerfectMatchedIndex("apple", "apple");
        assertEquals(perfect, List.of(0, 1, 2, 3, 4));
    }

    @Test
    @DisplayName("getPerfectMatchedIndex()에서 특정 글자가 완전일치할 경우 완전일치하는 글자 인덱스만 반환한다.")
    void partialMatch_getPerfectMatchedIndex() {

        List<Integer> partial = wordComparator.getPerfectMatchedIndex("appkk", "apple");
        assertEquals(partial, List.of(0, 1, 2));
    }

    @Test
    @DisplayName("getPerfectMatchedIndex()에서 완전일치하는 글자가 없을때는 빈 리스트를 반환한다.")
    void noMatch_getPerfectMatchedIndex() {

        List<Integer> noMatch = wordComparator.getPerfectMatchedIndex("kkkkk", "apple");
        assertEquals(noMatch, List.of());
    }

    @Test
    @DisplayName("getPartialMatchedIndex()에서 모든 글자가 부분일치 할 경우 단어의 전체 인덱스를 반환한다.")
    void fullyMatch_getPartialMatchedIndex() {

        List<Integer> perfect = wordComparator.getPartialMatchedIndex("leapp", "apple");
        assertEquals(perfect, List.of(0, 1, 2, 3, 4));
    }

    @Test
    @DisplayName("getPartialMatchedIndex()에서 특정 글자가 부분일치할 경우 부분일치하는 글자 인덱스만 반환한다.")
    void partialMatch_getPartialMatchedIndex() {

        List<Integer> partial = wordComparator.getPartialMatchedIndex("kkkpp", "apple");
        assertEquals(partial, List.of(3, 4));
    }

    @Test
    @DisplayName("getPartialMatchedIndex()에서 부분일치하는 글자가 없을때는 빈 리스트를 반환한다.")
    void noMatch_getPartialMatchedIndex() {

        List<Integer> noMatch = wordComparator.getPartialMatchedIndex("kkkkk", "apple");
        assertEquals(noMatch, List.of());
    }
}