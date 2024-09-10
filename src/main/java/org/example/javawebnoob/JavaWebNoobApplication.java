package org.example.javawebnoob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class JavaWebNoobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebNoobApplication.class, args);
    }

}
