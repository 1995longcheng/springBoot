package com.llc;

import com.llc.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by catt on 2019/11/18.
 springboot 单元测试；
 可以在测试期间很方便的类似编码一样进行自动注入等容器功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAppclicationStaterTest02 {

    @Autowired
    Person person;

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void testBean(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void contextLoads(){
        System.out.println(person);
    }
}
