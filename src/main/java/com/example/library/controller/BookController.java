package com.example.library.controller;



import com.example.library.common.ServerResponse;
import com.example.library.pojo.BookInfo;
import com.example.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class BookController {

    @Autowired
    IBookService bookService;
//
//    @RequestMapping(value ="/list",method = RequestMethod.GET)
//    public JSONObject getAllBookList(){
//        List<BookInfo> bookInfos;
//        JSONObject jsonObject = new JSONObject();
//        bookInfos = bookService.getAllBook();
//        //先将bookInfos转成JSONArray,也就是对象数组
//        JSONArray bookList=JSONArray.fromObject(bookInfos);
//        //然后用"allOfBook"对象存储这个对象数组,也就是bookList
//        jsonObject.put("allOfBook",bookList);
//        //返回JSON对象
//        return jsonObject;
//    }
//

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
