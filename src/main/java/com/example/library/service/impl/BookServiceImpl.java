package com.example.library.service.impl;

import com.example.library.dao.BookInfoMapper;
import com.example.library.pojo.BookInfo;
import com.example.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> getAllBook() {

        List<BookInfo> bookInfos = bookInfoMapper.getBookList();
        return bookInfos;
    }

}
