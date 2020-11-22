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


    @Override
    public ServerResponse getBorrowRecord() {
        List<BorrowRecord> borrowRecordList = borrowRecordMapper.getAllBorrowRecord();
        return ServerResponse.createBySuccessMessage("查询成功",borrowRecord2BorrowRecordVo(borrowRecordList));
    }

    @Override
    public ServerResponse borrowCheck(Integer borrowId,String bookCode) {
        //前端判断书为0即不能借阅
        borrowRecordMapper.updateStatusByIdAndBookCode(borrowId,bookCode);
        return ServerResponse.createBySuccessMessage("借阅审批成功");
    }

    @Override
    public ServerResponse getByCodeOrName(String bookName,String bookCode) {
        List<BorrowRecordVO> borrowRecordVOList = borrowRecord2BorrowRecordVo(borrowRecordMapper.getByCodeOrName(bookName,bookCode));
        return ServerResponse.createBySuccessMessage("获取对应书名或者书籍代码的书",borrowRecordVOList);
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
