package com.graphqljava.tutorial.bookDetails;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record Book(String id, String name, int pageCount, String authorId) {

    private static List<Book> books = Arrays.asList(
        new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
        new Book("book-2", "Moby Dick", 635, "author-2"),
        new Book("book-3", "Interview with the vampire", 371, "author-3")
    );

    public static Book getById(String id) {
        return books.stream().filter(book -> book.id().equals(id)).findFirst().orElse(null);
    }

    public static List<Book> getBooks(List<String> ids) {
        return
        books.stream()
                .filter(book -> ids.contains(book.id()))
                .collect(Collectors.toList());
    }

    public static Book addBook(BookInput book) {

        Book newBook = new Book(book.getId(), book.getName(), book.getPageCount(), book.getAuthorId());

        books.add(newBook);
        return newBook;
    }

}