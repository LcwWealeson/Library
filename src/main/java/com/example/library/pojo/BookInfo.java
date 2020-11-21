package com.example.library.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookInfo {
    private Integer bookId;

    private String bookName;

    private Integer bookCate;

    private String author;

    private String publisher;

    private String location;

    private String bookCode;

    private Date storeTime;

    private String image;

    private Integer number;

    private Integer numberBorrowed;

    private Integer numberStay;

    public BookInfo(Integer bookId, String bookName, Integer bookCate, String author, String publisher,
                    String location, String bookCode, Date storeTime, String image, Integer number, Integer numberBorrowed, Integer numberStay) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookCate = bookCate;
        this.author = author;
        this.publisher = publisher;
        this.location = location;
        this.bookCode = bookCode;
        this.storeTime = storeTime;
        this.image = image;
        this.number = number;
        this.numberBorrowed = numberBorrowed;
        this.numberStay = numberStay;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookCate() {
        return bookCate;
    }

    public void setBookCate(Integer bookCate) {
        this.bookCate = bookCate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumberBorrowed() {
        return numberBorrowed;
    }

    public void setNumberBorrowed(Integer numberBorrowed) {
        this.numberBorrowed = numberBorrowed;
    }

    public Integer getNumberStay() {
        return numberStay;
    }

    public void setNumberStay(Integer numberStay) {
        this.numberStay = numberStay;
    }

    public Date getStoreTime() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.parse(simpleDateFormat.format(storeTime));
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }


}