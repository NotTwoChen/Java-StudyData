package com.wsh.book.domain;
/**
 *  entity class from database bookstore with table book.
 *  Compiles all fields of a table into an entity class private property.
 *  And all attribute get/set methods are given.
 *  Create a constructor that has arguments and no arguments.
 *  Finally, the toString method is used to output the entity class attribute with String type.
 */
public class Book {

    private String bid;
    private String bname;
    private float price;
    private String author;
    private String image;
    private String cid;
    private int del;

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", cid='" + cid + '\'' +
                ", del=" + del +
                '}';
    }

    public Book() {
    }

    public Book(String bid, String bname, float price, String author, String image, String cid, int del) {

        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.image = image;
        this.cid = cid;
        this.del = del;
    }

    public String getBid() {

        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }
}
