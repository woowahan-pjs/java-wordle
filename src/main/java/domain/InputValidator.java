package domain;

import java.util.regex.Pattern;

public class InputValidator {


	public boolean validateEnglish(String input) {
		return Pattern.matches("^[a-zA-Z]+$", input);
	}
}
