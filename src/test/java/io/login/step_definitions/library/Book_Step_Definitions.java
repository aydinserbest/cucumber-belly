package io.login.step_definitions.library;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.login.libraryBooks.Book;

public class Book_Step_Definitions {

    @ParameterType("\"(.+)\" by (.+)")
    //@ParameterType(".*")
    public Book book(String title, String author) {
        return new Book(title, author); // Kitap nesnesi oluştur
    }
    // Given the selected book is "To Kill a Mockingbird" by Harper Lee
    @Given("the selected book is {book}")
    public void defineSelectedBook(Book book) {
        System.out.println("Selected Book: " + book);
    }
    /*
    @Given("the selected book is {string} by {string}")
    public void defineSelectedBook(String title, String author) {
        Book book = new Book(title, author); // Manuel olarak kitap nesnesi oluşturuyoruz
        System.out.println("Selected Book: " + book);
    }

     */

}
