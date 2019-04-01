package com.springboot_mybatis.dao;

import com.springboot_mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM user where id = #{id}")
    @Results({
            @Result(property = "address",column = "address_id",
            one = @One(select = "com.springboot_mybatis.dao.AddressRepository.findAddressById"))
    })
    User findUserWithAddress(@Param("id") Long id);

    @Select("select * from user where id=#{id}")
    @Results({
            //property = “cars”, 表示要将返回的查询结果赋值给user的cars属性
            //column = “id” 是指将user表中的用户主键id作为findCarByUserId的查询参数
            //many 表示这是一个一对多的查询
            //@Many(select = “方法全路径") 表示我们调用的方法, 方法参数userId就是上面column指定的列值
            @Result(property = "cars",column = "id",
            many = @Many(select = "com.springboot_mybatis.dao.CarRepository.findCarByUserId"))
    })
    User getUserWithCar(@Param("id") Long id);

    @Select("select * from user where id=#{id}")
    @Results({
            //property = “cars”, 表示要将返回的查询结果赋值给user的cars属性
            //column = “id” 是指将user表中的用户主键id作为findCarByUserId的查询参数
            //many 表示这是一个一对多的查询
            //@Many(select = “方法全路径") 表示我们调用的方法, 方法参数userId就是上面column指定的列值
            @Result(property = "cars",column = "id",
                    many = @Many(select = "com.springboot_mybatis.dao.CarRepository.findCarByUserId")),
            @Result(property = "address",column = "address_id",
            one = @One(select = "com.springboot_mybatis.dao.AddressRepository.findAddressById"))
    })
    User getUserWithCarAndAddress(@Param("id") Long id);
}
