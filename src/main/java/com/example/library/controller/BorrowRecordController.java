package com.example.library.controller;


import com.example.library.common.ServerResponse;
import com.example.library.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowRecordController {

    @Autowired
    IBorrowService borrowService;

    @GetMapping("/borrowRecords")
    public ServerResponse getAllBorrowRecord(){
        return borrowService.getBorrowRecord();
    }

    @GetMapping("/getByCodeOrName")
    public ServerResponse getByCodeOrName(String bookName,String bookCode){
        return borrowService.getByCodeOrName(bookName,bookCode);
    }

    @GetMapping("/checkedBorrow")
    public ServerResponse check(Integer borrowId,String bookCode){
        return borrowService.borrowCheck(borrowId,bookCode);
    }

}
