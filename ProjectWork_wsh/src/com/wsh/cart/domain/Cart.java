package com.wsh.cart.domain;
/**
 * Create an entity class that does not exist in any table in the database bookstore.
 * This is the shopping cart only for user private access to the main site page.
 * The entity class has only a private property of a Map collection.
 * The data stored in the Map collection is shopping entries and the corresponding number.
 * Like any other entity class, create the get/set method for the attributes of the entity class.
 * Create a constructor that has arguments and no arguments.
 * Finally, the toString method is used to output the entity class attribute with String type.
 */
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String,CartItem> cart = new HashMap<>();


    @Override
    public String toString() {
        return "Cart{" +
                "cart=" + cart +
                '}';
    }

    public Cart(Map<String, CartItem> cart) {
        this.cart = cart;
    }

    public Cart() {

    }

    public Map<String, CartItem> getCart() {

        return cart;
    }

    public void setCart(Map<String, CartItem> cart) {
        this.cart = cart;
    }
}
