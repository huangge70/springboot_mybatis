package com.springboot_mybatis.controller;

import com.springboot_mybatis.dao.UserRepository;
import com.springboot_mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findUserWithAddress/{id}")
    @ResponseBody
    public User findUserWithAddress(@PathVariable("id") long id){
        return userRepository.findUserWithAddress( id);
    }

    @RequestMapping(value = "/getUserWithCar/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserWithCar(@PathVariable("id") long id){
        return userRepository.getUserWithCar(id);
    }

    @RequestMapping(value = "/getUserWithCarAndAddress/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserWithCarAndAddress(@PathVariable("id") long id){
        return userRepository.getUserWithCarAndAddress(id);
    }
}
