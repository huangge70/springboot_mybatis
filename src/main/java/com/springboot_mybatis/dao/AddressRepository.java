package com.springboot_mybatis.dao;

import com.springboot_mybatis.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddressRepository {

    @Select("select * from address where id=#{id}")
    Address findAddressById(@Param("id") Long id);
}
