package francesca.pascalau.thesis.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("francesca.pascalau.thesis.rest")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
