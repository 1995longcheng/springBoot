package com.llc.bean;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by catt on 2019/11/18.
 *将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties:告诉springBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 * prefix = "person" ：配置文件中那个下面的所有属性进行一一映射
 *
 * @Component 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 *@ConfigurationProperties全局注入的方式可以配合@validated 进行数据校验  @validated+@Email 校验是否是邮箱格式
 *
 * 第三种注解注入值的方法@PropertySource+@ConfigurationProperties， PropertySource加载指定配置文件，这个可以读取文件，不必在全局配置文件中写
 */
@Component
@ConfigurationProperties(prefix = "person")
//@Validated

//@PropertySource(value = {"classpath:person.properties"})
public class Person {
    /***
     * 第二种注入值的注解是@value
     * <bean class="Person">
     *     <property name"lastName" value="字面变量/${key}从环境变量、配置文件中获取值/#{Spel}计算"></>
     * <bean/>
     */
//    @Value("#{11*2}")
//    @Email
    private Integer age;
//    @Value("${last-name}")
//    @Email
    private String lastName;
    private List<Object> lists;
    private Map<String,Object> maps;
    private Date birth;
//    @Value("true")
    private boolean boss;
    private Dog dog;

    @Override
    public String toString() {
        return "person{" +
                "lastName='" + lastName + '\'' +
                ",age= " + age +
                ",boss= " + boss +
                ",birth= " + birth +
                ",maps= " + maps +
                ",list= " + lists +
                ",dog= " + dog + '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
