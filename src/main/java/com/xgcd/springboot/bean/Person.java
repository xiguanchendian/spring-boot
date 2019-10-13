package com.xgcd.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中的配置映射到这个组件中
 *
 * @ConfigurationProperties(prefix = "person") 默认从全局配置文件application.properties或application.yml中获取值,
 *                          告诉springboot将本类中的所有属性和配置文件中的相关配置进行绑定:
 *                          prefix:配置文件中的哪个属性下的所有属性进行一一绑定
 * 只有该组件是容器中的组件才可以发挥作用(提供@ConfigurationProperties功能),所以加了@Component注解
 *
 * 可以在test中进行单元测试
 *
 * @PropertySource(value = {"classpath:person.properties"}, encoding = "utf-8") 加载指定的配置文件
 *
 */
@Component
@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:person.properties"}, encoding = "utf-8")
public class Person {
    private String lastName;
    private Integer age;
    private boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
