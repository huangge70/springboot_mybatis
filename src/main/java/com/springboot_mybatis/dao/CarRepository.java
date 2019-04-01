package com.springboot_mybatis.dao;

import com.springboot_mybatis.pojo.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarRepository {
    @Select("SELECT * FROM car WHERE user_id = #{userId}")
    List<Car> findCarByUserId(@Param("userId") Long userId);
}
