package com.example.library.vo;

import com.example.library.pojo.BookInfo;

public class BookInfoVO extends BookInfo {

    private String dateTime ;
    public BookInfoVO() {
        super();
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
