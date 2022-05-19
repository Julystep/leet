package com.example.springaop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: liml
 * @date: 2022/5/18
 */
@Mapper
public interface MyMapper {

    @Select("select count(*) from user")
    Integer select();

}
