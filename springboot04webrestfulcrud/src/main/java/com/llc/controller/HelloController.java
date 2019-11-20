package com.llc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by catt on 2019/11/20.
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello world";
    }

    //查出一些数据，在页面展示
    @RequestMapping("/success")
    @ResponseBody
    public String success(Map<String, Object> map){
        map.put("hello", "你好");
        return "success";
    }
}
