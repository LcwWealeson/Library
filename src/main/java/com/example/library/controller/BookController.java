package com.example.library.controller;



import com.example.library.common.ServerResponse;
import com.example.library.pojo.BookInfo;
import com.example.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/list")
    public ServerResponse getList() {
        return bookService.getBook();
    }

    @PostMapping("/add")
    public ServerResponse addBook(@RequestBody BookInfo bookInfo){
        return bookService.addBook(bookInfo);
    }

    @GetMapping("/getByCodeOrName")
    public ServerResponse getByCodeOrName(String bookCode, String bookName){
        return bookService.getBookByCodeOrName(bookCode,bookName);
    }

    //下架图书
    @GetMapping("/takeOffBook")
    public ServerResponse deleteBook(Integer bookId){
        return bookService.deleteByBookId(bookId);
    }

    @GetMapping("/updateBook")
    public ServerResponse updateBook(Integer bookId,String bookName,String author,String publisher){
        return bookService.updateBook(bookId,bookName,author,publisher);
    }
}
