package wordle.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordle.design.WordGenerator;

class WordGeneratorImplTest {

  WordGenerator wordGenerator = new WordGeneratorImpl();

  @Test
  @DisplayName("파일을 배열로 잘라서 만든다")
  void test1() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/words.txt"));
    List<String> listOfLines = new ArrayList<>();
    String line = bufferedReader.readLine();

    while (line != null) {
      listOfLines.add(line);
      line = bufferedReader.readLine();
    }
    Assertions.assertThat((long) listOfLines.size()).isEqualTo(2309);
  }
}