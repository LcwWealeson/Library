package com.example.library.service.impl;

import com.example.library.common.ServerResponse;
import com.example.library.dao.BookInfoMapper;
import com.example.library.pojo.*;
import com.example.library.service.IBookService;
import com.example.library.utils.DateUtil;
import com.example.library.vo.BookInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public ServerResponse getBook() {
        List<BookInfo> bookInfoList = bookInfoMapper.getBookList();
        return ServerResponse.createBySuccessMessage("查询成功",bookInfo2BookInfoVo(bookInfoList));
    }

    @Override
    public ServerResponse addBook(BookInfo bookInfo) {
        int resultRow = bookInfoMapper.insertSelective(bookInfo);
        if(resultRow==0){
            return ServerResponse.createByErrorMessage("插入失败");
        }
        return ServerResponse.createBySuccessMessage("插入成功");
    }


    //example的用法
    @Override
    public ServerResponse getBookByCodeOrName(String bookCode, String bookName) {

        List<BookInfo> bookInfoList = bookInfoMapper.getBookByCodeOrName(bookCode,bookName);
        return ServerResponse.createBySuccessMessage("查询成功",bookInfo2BookInfoVo(bookInfoList));
    }





    //bookInfo 和 bookInfoVO 类型转化 ，时间转化为string
    public List<BookInfoVO> bookInfo2BookInfoVo(List<BookInfo> bookInfoList) {
        List<BookInfoVO> bookInfoVOList = new ArrayList<>();
        for (BookInfo bookInfo : bookInfoList) {
            String datetime = DateUtil.dateToStr(bookInfo.getStoreTime());
            BookInfoVO bookInfoVO = new BookInfoVO();
            BeanUtils.copyProperties(bookInfo, bookInfoVO);
            bookInfoVO.setDateTime(datetime);
            bookInfoVOList.add(bookInfoVO);
        }
        return bookInfoVOList;
    }
}
