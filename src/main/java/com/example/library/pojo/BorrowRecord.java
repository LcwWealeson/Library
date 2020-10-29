package com.example.library.pojo;

import java.util.Date;

public class BorrowRecord {
    private Integer id;

    private String bookThirdcate;

    private String bookName;

    private Integer userId;

    private Date startTime;

    private Date endTime;

    private Date ownTime;

    private Integer bookId;

    private Integer continueTimes;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookThirdcate() {
        return bookThirdcate;
    }

    public void setBookThirdcate(String bookThirdcate) {
        this.bookThirdcate = bookThirdcate == null ? null : bookThirdcate.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getOwnTime() {
        return ownTime;
    }

    public void setOwnTime(Date ownTime) {
        this.ownTime = ownTime;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getContinueTimes() {
        return continueTimes;
    }

    public void setContinueTimes(Integer continueTimes) {
        this.continueTimes = continueTimes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}