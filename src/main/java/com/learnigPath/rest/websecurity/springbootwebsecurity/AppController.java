package com.learnigPath.rest.websecurity.springbootwebsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello guys welcome into the Spring security world !!";
    }

    @GetMapping("/anybody")
    public String anybody()
    {
        return "hello anyBody welcome into the Spring security world !!";
    }
}
