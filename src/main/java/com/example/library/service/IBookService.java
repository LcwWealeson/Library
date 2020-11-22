package com.example.library.service;

import com.example.library.common.ServerResponse;
import com.example.library.pojo.BookInfo;

import java.util.List;


public interface IBookService {

    List<BookInfo> getAllBook();

    ServerResponse getBook();

    ServerResponse addBook(BookInfo bookInfo);

    ServerResponse getBookByCodeOrName(String bookCode ,String bookName);

    ServerResponse deleteByBookId(Integer bookId);

    ServerResponse updateBook(Integer bookId,String bookName, String author, String publisher);
}
