package com.example.library.service;

import com.example.library.common.ServerResponse;

public interface IBorrowService {

    ServerResponse getBorrowRecord();

    ServerResponse getByCodeOrName(String bookName, String bookCode);

    ServerResponse borrowCheck(Integer borrowId, String bookId);

    ServerResponse returnBook(Integer borrowId, String bookCode);

    ServerResponse getBorrowedByCodeOrName(String bookName, String bookCode);

    ServerResponse getAllBorrowedRecord();

    ServerResponse updateBook(Integer bookId, String bookName);
}
