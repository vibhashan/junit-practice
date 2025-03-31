package org.vibhashana.junit_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.vibhashana.junit_practice.collections.BookDetails;
import org.vibhashana.junit_practice.schemas.Book;

class BookDetailsTest {
	private static BookDetails bookDetails;

	@BeforeAll
	static void beforeAll() {
		Book book = new Book(1, "The Lord of the Rings", 49.99, "J.R.R. Tolkien");
		Book book2 = new Book(2, "The Hobbit", 29.99, "J.R.R. Tolkien");

		bookDetails = new BookDetails();
		bookDetails.addBook(book);
		bookDetails.addBook(book2);
	}

	@AfterAll
	static void afterAll() {
		bookDetails = null;
	}

	@Test
	void test() {
		assertEquals(2, BookDetails.displayBookCount());
		assertNotNull(bookDetails);
	}

}
