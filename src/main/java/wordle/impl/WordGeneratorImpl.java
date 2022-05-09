package wordle.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import wordle.design.WordGenerator;

public class WordGeneratorImpl implements WordGenerator {

  private static final List<String> WORDS = readFile();
  private static final String REFERENCE_DATE = "2021-06-19";

  @Override
  public String execute() {
    return WORDS.get(findIndex());
  }

  private static List<String> readFile() {

    BufferedReader bufferedReader = null;
    List<String> listOfLines = new ArrayList<>();

    try {
      bufferedReader = new BufferedReader(new FileReader("src/main/resources/words.txt"));

      String line = bufferedReader.readLine();

      while (line != null) {
        listOfLines.add(line);
        line = bufferedReader.readLine();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return listOfLines;
  }

  private int findIndex() {
    LocalDate now = LocalDate.now();
    LocalDate referenceDay = LocalDate.parse(REFERENCE_DATE, DateTimeFormatter.ISO_LOCAL_DATE);
    Duration diff = Duration.between(referenceDay.atStartOfDay(), now.atStartOfDay());
    long diffDays = diff.toDays();

    return (int) (diffDays % WORDS.size());
  }
}
