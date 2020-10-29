package com.example.library.dao;

import com.example.library.pojo.BookSecondCate;
import com.example.library.pojo.BookSecondCateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookSecondCateMapper {
    long countByExample(BookSecondCateExample example);

    int deleteByExample(BookSecondCateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookSecondCate record);

    int insertSelective(BookSecondCate record);

    List<BookSecondCate> selectByExample(BookSecondCateExample example);

    BookSecondCate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookSecondCate record, @Param("example") BookSecondCateExample example);

    int updateByExample(@Param("record") BookSecondCate record, @Param("example") BookSecondCateExample example);

    int updateByPrimaryKeySelective(BookSecondCate record);

    int updateByPrimaryKey(BookSecondCate record);
}