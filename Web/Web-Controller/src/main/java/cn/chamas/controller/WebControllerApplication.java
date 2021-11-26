package cn.chamas.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cn.chamas")
public class WebControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebControllerApplication.class, args);
    }

}
