package com.llc.controller;

import com.llc.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by catt on 2019/11/28.
 */
@ControllerAdvice
public class MyExceptionHandler {

    /*
    //1、这样写死，浏览器和客户端返回的都是json
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态吗 4xx, 5xx
        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        //转发到/error
        return "forward:/error";
    }
}
