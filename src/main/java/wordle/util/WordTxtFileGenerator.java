package wordle.util;

import java.io.File;

public class WordTxtFileGenerator {
    public static final String WORD_TXT_FILE_PATH = "./src/main/resources/";

    public static File scanWordListFromWordTxtFile(String wordTxtFileName) {
        final String filePath = WORD_TXT_FILE_PATH + wordTxtFileName;

        return new File(filePath);
    }
}
