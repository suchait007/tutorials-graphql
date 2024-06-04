package com.graphqljava.tutorial.bookDetails;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
class BookController {

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> findBooks(@Argument List<String> ids) {
        return Book.getBooks(ids);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }


    @MutationMapping
    public Book addBook(@Argument BookInput bookInput) {
        return Book.addBook(bookInput);
    }



}