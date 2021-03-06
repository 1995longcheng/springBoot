package com.llc.config;

import com.llc.component.LoginHandlerInterceptor;
import com.llc.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by catt on 2019/11/21.
 * 使用
 */
//@EnableWebMvc//这个注解是全面接管mvc的自动配置的，如果启用这个注解，springbootMVC自动配置将会全部失效
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

//    @Bean
//    public WebServerFactoryCustomizer embeddedWebServerFactoryCustomizerAutoConfiguration(){
//        return new EmbeddedWebServerFactoryCustomizerAutoConfiguration(){
//          //定制嵌入式的servlet容器相关的规则
//            @Override
//            public void Customers(Configuraa)
//        };
//    }

    @Override
    public  void addViewControllers(ViewControllerRegistry registry){
        //super.addViewControllers(registry);
        //浏览器发送 /llc 请求到success
        registry.addViewController("/llc").setViewName("success");
    }

    //所有的WebMvcconfigurerAadpter组件都会一起起作用
    @Bean//将组件注册在容器中才生效
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer webMvcConfigurer   =  new WebMvcConfigurer(){

           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("index");
               registry.addViewController("/index.html").setViewName("index");
               registry.addViewController("/main.html").setViewName("dashboard");
           }

           //注册拦截器
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
//               super.addInterceptors(registry);
//               静态资源 *.css , *.js springboot 已经做好了静态资源映射,实验不行，要加exclude去除过滤
               /**
                * /** 代码拦截这个目录下面所有的
                */
               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                       .excludePathPatterns("/index.html", "/", "/user/login","*.css","*.js");
           }

       };
       return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }



}
