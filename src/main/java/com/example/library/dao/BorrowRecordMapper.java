package com.example.library.dao;

import com.example.library.pojo.BorrowRecord;
import com.example.library.pojo.BorrowRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowRecordMapper {
    long countByExample(BorrowRecordExample example);

    int deleteByExample(BorrowRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BorrowRecord record);

    int insertSelective(BorrowRecord record);

    List<BorrowRecord> selectByExample(BorrowRecordExample example);

    BorrowRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BorrowRecord record, @Param("example") BorrowRecordExample example);

    int updateByExample(@Param("record") BorrowRecord record, @Param("example") BorrowRecordExample example);

    int updateByPrimaryKeySelective(BorrowRecord record);

    int updateByPrimaryKey(BorrowRecord record);

    int updateBook(Integer bookId, String bookName);

    List<BorrowRecord> getAllBorrowRecord();

    List<BorrowRecord> getAllBorrowedRecords();

    int updateStatusByIdAndBookCode(Integer borrowId, String bookCode, Integer status);

    List<BorrowRecord> getByCodeOrName(String bookName, String bookCode);

    List<BorrowRecord> getBorrowedByCodeOrName(String bookName, String bookCode);
}