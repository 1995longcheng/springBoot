package com.llc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by catt on 2019/11/18.
 * @ImportResource  导入spring的配置文件，使其生效
 */
//@ImportResource(value = {"classpath:spring-config.xml"})
@SpringBootApplication
public class SpringAppclicationStater {
    public static void main(String[] args) {
        SpringApplication.run(SpringAppclicationStater.class,args);
    }
}
