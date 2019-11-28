package com.llc.controller;

import com.llc.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by catt on 2019/11/20.
 */
@Controller
public class HelloController {

    //默认访问classpath/public/index首页，这里做处理设置访问模板引擎里面的首页
    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();

        }
        return "hello world";
    }

    //查出一些数据，在页面展示
    @RequestMapping("/success")
//    @ResponseBody  这个注解会使thymeleaf解析模板失效，返回return的字符串。
    public String success(Map<String, Object> map){
        map.put("hello", "<h1>你好<h1/>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
