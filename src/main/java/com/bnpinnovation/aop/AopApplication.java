package com.bnpinnovation.aop;

import com.bnpinnovation.aop.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
        HelloService helloService = (HelloService) context.getBean("hello");
        List<String> helloStrings = Arrays.asList("hello, world");
        helloService.helloStrings(helloStrings);
        helloService.helloString("good");
    }

}
