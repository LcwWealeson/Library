package com.example.library.dao;

import com.example.library.pojo.BookThirdCate;
import com.example.library.pojo.BookThirdCateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookThirdCateMapper {
    long countByExample(BookThirdCateExample example);

    int deleteByExample(BookThirdCateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookThirdCate record);

    int insertSelective(BookThirdCate record);

    List<BookThirdCate> selectByExample(BookThirdCateExample example);

    BookThirdCate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookThirdCate record, @Param("example") BookThirdCateExample example);

    int updateByExample(@Param("record") BookThirdCate record, @Param("example") BookThirdCateExample example);

    int updateByPrimaryKeySelective(BookThirdCate record);

    int updateByPrimaryKey(BookThirdCate record);
}