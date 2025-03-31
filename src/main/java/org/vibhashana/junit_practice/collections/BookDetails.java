package org.vibhashana.junit_practice.collections;

import java.util.ArrayList;
import java.util.List;

import org.vibhashana.junit_practice.exceptions.MyException;
import org.vibhashana.junit_practice.schemas.Book;

public class BookDetails {
	private static List<Book> books = new ArrayList<>();;

	public static void addBook(Book book) {
		books.add(book);
		System.out.println("Book added successfully 😋.\n");
	}

	public static void displayBooks() throws MyException {
		System.out.println("\n---------- Listing all books ----------\n");

		if (books.isEmpty())
			throw new MyException("No books to display 😥.\n");
		else {
			for (Book book : books) {
				System.out.println(book.toString());
			}
			System.out.println();
		}

	}

	public static int getLastBookId() {
		if (books.isEmpty())
			return 0;

		return books.get(books.size() - 1).getId();
	}

	public static void displayBookCount() {
		System.out.println("\n---------- Book Count: " + books.size() + " ----------\n");
	}
}
