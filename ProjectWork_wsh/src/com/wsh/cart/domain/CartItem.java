package com.wsh.cart.domain;
/**
 * Create an entity class that does not exist in any table in the database bookstore.
 * This is the shopping entry that is used only for user private access to the main site page.
 * There is only the instantiated object of the book type and an int type attribute in the entity class.
 * Like any other entity class, create the get/set method for the attributes of the entity class.
 * Create a constructor that has arguments and no arguments.
 * Finally, the toString method is used to output the entity class attribute with String type.
 */

import com.wsh.book.domain.Book;

public class CartItem {
    private Book book;
    private int count;

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                '}';
    }

    public CartItem() {
    }

    public CartItem(Book book, int count) {

        this.book = book;
        this.count = count;
    }

    public Book getBook() {

        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
