package com.example.library.dao;

import com.example.library.pojo.Propaganda;
import com.example.library.pojo.PropagandaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropagandaMapper {
    long countByExample(PropagandaExample example);

    int deleteByExample(PropagandaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Propaganda record);

    int insertSelective(Propaganda record);

    List<Propaganda> selectByExample(PropagandaExample example);

    Propaganda selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Propaganda record, @Param("example") PropagandaExample example);

    int updateByExample(@Param("record") Propaganda record, @Param("example") PropagandaExample example);

    int updateByPrimaryKeySelective(Propaganda record);

    int updateByPrimaryKey(Propaganda record);
}