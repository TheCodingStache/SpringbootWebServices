package com.dmspallas.webservices.restfulwebservices.hello;

import com.dmspallas.webservices.restfulwebservices.hello.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
