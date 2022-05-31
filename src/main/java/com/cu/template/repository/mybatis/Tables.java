package com.cu.template.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Tables {

    @Select("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = #{schema}")
    List<Map> findAll(String schema);



}
