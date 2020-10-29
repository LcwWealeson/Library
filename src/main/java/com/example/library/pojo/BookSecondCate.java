package com.example.library.pojo;

public class BookSecondCate {
    private Integer id;

    private String name;

    private Integer firstcateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFirstcateId() {
        return firstcateId;
    }

    public void setFirstcateId(Integer firstcateId) {
        this.firstcateId = firstcateId;
    }
}