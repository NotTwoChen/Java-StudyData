package com.wsh.book.domain;

public class Book {

    private int bid;
    private String bname;
    private int price;
    private String author;
    private String cover;
    private int cid;

    public Book() {
    }

    public Book(int bid, String bname, int price, String author, String cover, int cid) {

        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.cover = cover;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", cid=" + cid +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
