package wordle.util;

import java.io.File;

public class WordTxtFileGenerator {
    public static final String WORD_TXT_FILE_PATH = "./src/main/resources/";

    public static File generateFromFileName(String txtFileName) {
        final String filePath = WORD_TXT_FILE_PATH + txtFileName;

        return new File(filePath);
    }
}