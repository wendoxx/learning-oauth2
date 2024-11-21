package org.example.learningoauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/public")
    public String publicHello() {
        return "Hello, i'm public!";
    }

    @GetMapping("/private")
    public String privateHello() {
        return "Hello, i'm private!";
    }
}
