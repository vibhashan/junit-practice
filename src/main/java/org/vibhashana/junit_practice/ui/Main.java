package org.vibhashana.junit_practice.ui;

import java.util.Scanner;

import org.vibhashana.junit_practice.collections.BookDetails;
import org.vibhashana.junit_practice.exceptions.MyException;
import org.vibhashana.junit_practice.schemas.Book;
import org.vibhashana.junit_practice.validation.BookValidation;

public class Main {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			showMenu();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void showMenu() throws InterruptedException, MyException {
		System.out.println("---------- Welcome to Hogwartz Library 😀 ----------\n");

		String bookName;
		String author;
		double price;

		boolean shouldLoop = true;

		while (shouldLoop) {
			System.out.println("1. Add book");
			System.out.println("2. Display books");
			System.out.println("3. Exit system");

			System.out.print("\nEnter your choice (1/2/3):");
			System.out.println();

			int choice = input.nextInt();

			switch (choice) {
			case 1: {
				System.out.print("Enter book name: ");
				bookName = input.next();

				boolean isBookNameValid = false;

				try {
					isBookNameValid = BookValidation.validateBookName(bookName);
				} catch (MyException e) {
					System.out.println("\n##### " + e.getMessage() + " #####");
				}

				while (!isBookNameValid) {
					System.out.print("Enter book name: ");
					bookName = input.next();
				}

				System.out.print("Enter author name: ");
				author = input.next();

				boolean isAuthorValid = false;
				try {
					isAuthorValid = BookValidation.validateBookAuthor(author);
				} catch (MyException e) {
					System.out.println("\n##### " + e.getMessage() + " #####");
				}

				while (!isAuthorValid) {
					System.out.print("Enter author name: ");
					author = input.next();
				}

				System.out.print("Enter book price: ");
				price = input.nextDouble();

				boolean isPriceValid = false;
				try {
					isPriceValid = BookValidation.validateBookPrice(price);
				} catch (MyException e) {
					System.out.println("\n##### " + e.getMessage() + " #####");
				}

				while (!isPriceValid) {
					System.out.print("Enter book price: ");
					price = input.nextDouble();
				}

				Book book = new Book();
				book.setId(BookDetails.getLastBookId() + 1);
				book.setAuthor(author);
				book.setName(bookName);
				book.setPrice(price);

				BookDetails.addBook(book);

				System.out.println();

				break;
			}

			case 2: {
				try {
					BookDetails.displayBooks();
				} catch (MyException e) {
					System.out.println(e.getMessage());
				}

				break;
			}

			case 3: {
				System.out.println("\n---------- Thank you 😉, see you again! ----------");
				shouldLoop = false;
				break;
			}

			default: {
				System.out.println("Invalid choice. Please try again");
				Thread.sleep(1000);
				break;
			}
			}
		}
	}
}
