package org.vibhashana.junit_practice.validation;

import java.util.regex.Pattern;

import org.vibhashana.junit_practice.exceptions.MyException;

public class BookValidation {
	public static boolean validateBookName(String name) throws MyException {
		String nameRegex = "^[\\p{L}\\d.,'’“”\"!?&:;()\\-\\s]+$";

		if (!Pattern.matches(nameRegex, name))
			throw new MyException("Book name is invalid");
		else
			return true;
	}

	public static boolean validateBookPrice(double price) throws MyException {
		String priceRegex = "^(\\$|€|£)?\\d{1,7}(\\.\\d{1,2})?$";

		if (!Pattern.matches(priceRegex, String.valueOf(price)))
			throw new MyException("Book price is an invalid number");
		else
			return true;
	}

	public static boolean validateBookAuthor(String author) throws MyException {
		String authorRegex = "^[\\p{L}]+([ '-][\\p{L}]+)*$";

		if (!Pattern.matches(authorRegex, author))
			throw new MyException("Book author is an invalid");
		else
			return true;
	}
}
