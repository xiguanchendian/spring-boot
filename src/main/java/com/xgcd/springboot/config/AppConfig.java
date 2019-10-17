package com.xgcd.springboot.config;

import com.xgcd.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 指明当前类是一个配置类, 就是来替代之前的spring配置文件beans.xml
 */
@Configuration
public class AppConfig {

    // 使用@Bean给容器中添加组件,将方法的返回值添加到容器中,容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService() {
        System.out.println("配置类@Bean给容器中添加组件成功...");
        return new HelloService();
    }

}
