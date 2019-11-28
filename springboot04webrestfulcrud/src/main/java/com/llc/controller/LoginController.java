package com.llc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by catt on 2019/11/21.
 */
@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String loginSuccess(@RequestParam("username") String userName,
                               @RequestParam("password") String password ,
                               Map<String,Object> map, HttpSession session, Model model){
        if (!StringUtils.isEmpty(userName) && "1234".equals(password)){
            //增加过滤器，用session来标记以登陆
            session.setAttribute("loginUser",userName);
            model.addAttribute("userName",userName);
            //登陆成功,防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        }else {
//            登陆失败
            map.put("msg","用户名或密码错误");
            return "index";
        }
    }
}
