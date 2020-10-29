package com.example.library.dao;

import com.example.library.pojo.BookFirstCate;
import com.example.library.pojo.BookFirstCateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookFirstCateMapper {
    long countByExample(BookFirstCateExample example);

    int deleteByExample(BookFirstCateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookFirstCate record);

    int insertSelective(BookFirstCate record);

    List<BookFirstCate> selectByExample(BookFirstCateExample example);

    BookFirstCate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookFirstCate record, @Param("example") BookFirstCateExample example);

    int updateByExample(@Param("record") BookFirstCate record, @Param("example") BookFirstCateExample example);

    int updateByPrimaryKeySelective(BookFirstCate record);

    int updateByPrimaryKey(BookFirstCate record);
}