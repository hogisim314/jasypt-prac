package org.example.jasyptdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @Value("${spring.test.username}")
    private String username;

    @Value("${spring.test.password}")
    private String password;

    @GetMapping("/")
    public String getTestInfo() {
        System.out.printf("Username: %s, Password: %s%n", username, password);
        return String.format("Username: %s, Password: %s", username, password);
    }
}
