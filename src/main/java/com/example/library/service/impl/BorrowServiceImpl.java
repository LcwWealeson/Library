package com.example.library.service.impl;

import com.example.library.common.ServerResponse;
import com.example.library.dao.BookInfoMapper;
import com.example.library.dao.BorrowRecordMapper;
import com.example.library.dao.UserMapper;
import com.example.library.pojo.BorrowRecord;
import com.example.library.pojo.User;
import com.example.library.service.IBorrowService;
import com.example.library.utils.DateUtil;
import com.example.library.vo.BorrowRecordVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements IBorrowService {

    @Autowired
    BorrowRecordMapper borrowRecordMapper;

    @Autowired
    BookInfoMapper bookInfoMapper;

    @Autowired
    UserMapper userMapper;


    //借阅系统 获取所有借阅预约申请
    @Override
    public ServerResponse getBorrowRecord() {
        List<BorrowRecord> borrowRecordList = borrowRecordMapper.getAllBorrowRecord();
        return ServerResponse.createBySuccessMessage("查询成功",borrowRecord2BorrowRecordVo(borrowRecordList));
    }

    //归还系统 获取所有已借出但未归还的记录
    @Override
    public ServerResponse getAllBorrowedRecord() {
        return ServerResponse.createBySuccessMessage("查询成功",
                borrowRecord2BorrowRecordVo(borrowRecordMapper.getAllBorrowedRecords()));
    }


    //审核借阅通过
    @Override
    public ServerResponse borrowCheck(Integer borrowId,String bookCode) {
        Integer status =2;
        int bookRow = bookInfoMapper.updateStatusByIdAndBookCode(bookCode,status);
        int recordRow = borrowRecordMapper.updateStatusByIdAndBookCode(borrowId,bookCode,status);
        return ServerResponse.createBySuccessMessage("借阅审批成功："+bookRow+"，书籍代码："+bookCode);
    }

    //归还图书
    @Override
    public ServerResponse returnBook(Integer borrowId, String bookCode) {
        Integer status =0;
        int bookRow = bookInfoMapper.updateStatusByIdAndBookCode(bookCode,status);
        int recordRow = borrowRecordMapper.updateStatusByIdAndBookCode(borrowId,bookCode,status);
        return ServerResponse.createBySuccessMessage("归还图书几本："+bookRow+"，书籍代码："+bookCode);
    }

    //借阅系统查询 参数可为：书名、书籍代码
    @Override
    public ServerResponse getByCodeOrName(String bookName,String bookCode) {
        List<BorrowRecordVO> borrowRecordVOList = borrowRecord2BorrowRecordVo(borrowRecordMapper.getByCodeOrName(bookName,bookCode));
        return ServerResponse.createBySuccessMessage("获取对应书名或者书籍代码的书",borrowRecordVOList);
    }
    //归还系统查询 参数可为：书名、书籍代码
    @Override
    public ServerResponse getBorrowedByCodeOrName(String bookName, String bookCode) {
        List<BorrowRecordVO> borrowRecordVOList = borrowRecord2BorrowRecordVo(borrowRecordMapper.getBorrowedByCodeOrName(bookName,bookCode));
        return ServerResponse.createBySuccessMessage("获取对应书名或者书籍代码的书",borrowRecordVOList);
    }

    @Override
    public ServerResponse updateBook(Integer bookId, String bookName) {
        return ServerResponse.createBySuccessMessage("修改借阅表的书名",borrowRecordMapper.updateBook(bookId,bookName));
    }

    //BorrowRecord 和 BorrowRecordVO 类型转化 ，增加record对应的User，时间转化为string
    public List<BorrowRecordVO> borrowRecord2BorrowRecordVo(List<BorrowRecord> borrowRecordList) {
        List<BorrowRecordVO> borrowRecordVOList = new ArrayList<>();
        String timeStart;
        String timeEnd;
        User user;
        BorrowRecordVO borrowRecordVO = new BorrowRecordVO();
        for (BorrowRecord borrowRecord : borrowRecordList) {
            timeStart = DateUtil.dateToStr(borrowRecord.getStartTime());
            timeEnd = DateUtil.dateToStr(borrowRecord.getEndTime());
            BeanUtils.copyProperties(borrowRecord, borrowRecordVO);
            user = userMapper.selectByPrimaryKey(borrowRecord.getUserId());
            borrowRecordVO.setTimeStart(timeStart);
            borrowRecordVO.setTimeEnd(timeEnd);
            borrowRecordVO.setUser(user);//加上User

            borrowRecordVOList.add(borrowRecordVO);
        }
        return borrowRecordVOList;
    }
}
