package com.example.library.dao;

import com.example.library.pojo.BorrowRecord;
import com.example.library.pojo.BorrowRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowRecordMapper {
    long countByExample(BorrowRecordExample example);

    int deleteByExample(BorrowRecordExample example);

    int insert(BorrowRecord record);

    int insertSelective(BorrowRecord record);

    List<BorrowRecord> selectByExample(BorrowRecordExample example);

    int updateByExampleSelective(@Param("record") BorrowRecord record, @Param("example") BorrowRecordExample example);

    int updateByExample(@Param("record") BorrowRecord record, @Param("example") BorrowRecordExample example);
}