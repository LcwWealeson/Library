package com.example.library.controller;


import com.example.library.common.ServerResponse;
import com.example.library.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowRecordController {

    @Autowired
    IBorrowService borrowService;
    //借阅系统 获取所有记录
    @GetMapping("/getBorrowRecords")
    public ServerResponse getAllBorrowRecord(){
        return borrowService.getBorrowRecord();
    }

    //归还系统 获取所有记录
    @GetMapping("/getAllBorrowedRecord")
    public ServerResponse getAllBorrowedRecord(){
        return borrowService.getAllBorrowedRecord();
    }

    //借阅系统中查询指定的借阅预约申请
    @GetMapping("/getBorrowByCodeOrName")
    public ServerResponse getByCodeOrName(String bookName, String bookCode){
        return borrowService.getByCodeOrName(bookName,bookCode);
    }

    //归还系统中查询已借出但未归还的书籍
    @GetMapping("/getBorrowedByCodeOrName")
    public ServerResponse getBorrowedByCodeOrName(String bookName, String bookCode){
        return borrowService.getBorrowedByCodeOrName(bookName,bookCode);
    }

    //借阅审批通过
    @GetMapping("/checkedBorrowTo2")
    public ServerResponse checkTo2(@RequestParam("borrowId") Integer borrowId,
                                   @RequestParam("bookCode") String bookCode){
        return borrowService.borrowCheck(borrowId,bookCode);
    }
    //归还图书
    @GetMapping("/returnTo0")
    public ServerResponse returnTo0(@RequestParam("borrowId") Integer borrowId,
                                    @RequestParam("bookCode") String bookCode){
        return borrowService.returnBook(borrowId,bookCode);
    }

    //更新图书
    @GetMapping("/updateBorrowRecord")
    public ServerResponse updateBorrowRecord(Integer bookId,String bookName){
        return borrowService.updateBook(bookId,bookName);
    }


}
