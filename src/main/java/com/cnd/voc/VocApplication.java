package com.cnd.voc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VocApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(VocApplication.class, args);

    }

}
