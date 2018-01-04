package com.wsh.project.bean;

public class Book {
    private int bid;
    private String bname;
    private String author;
    private int price;
    private String cover;
    private String content;

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", cover='" + cover + '\'' +
                ", content='" + content + '\'' +
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book(int bid, String bname, String author, int price, String cover, String content) {

        this.bid = bid;
        this.bname = bname;
        this.author = author;
        this.price = price;
        this.cover = cover;
        this.content = content;
    }

    public Book(String bname, String author, int price, String cover, String content) {
        this.bname = bname;
        this.author = author;
        this.price = price;
        this.cover = cover;
        this.content = content;
    }

    public Book(String bname, String author, int price, String cover) {
        this.bname = bname;
        this.author = author;
        this.price = price;
        this.cover = cover;
    }

    public Book(String bname, String author, int price) {
        this.bname = bname;
        this.author = author;
        this.price = price;
    }

    public Book(String bname, String author) {
        this.bname = bname;
        this.author = author;
    }

    public Book(String bname) {
        this.bname = bname;
    }


    public Book() {

    }
}