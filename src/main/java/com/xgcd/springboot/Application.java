package com.xgcd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication 该注解用于标注一个主程序类, 说明这是一个springboot应用
 * @ImportResource 导入spring的配置文件, 使配置文件里面的内容生效
 */
//@ImportResource(locations = {"classpath:spring-beans.xml"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
