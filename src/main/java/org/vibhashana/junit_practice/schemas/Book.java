package org.vibhashana.junit_practice.schemas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private int id;
	private String name;
	private double price;
	private String author;

	@Override
	public String toString() {
		return String.format("ID: %d, Name: %s, Price: %f, Author: %s", id, name, price, author);
	}
}
