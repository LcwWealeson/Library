package com.example.library.vo;

import com.example.library.pojo.BorrowRecord;
import com.example.library.pojo.User;

public class BorrowRecordVO extends BorrowRecord {

    private User user;
    private String timeStart;
    private String timeEnd;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
