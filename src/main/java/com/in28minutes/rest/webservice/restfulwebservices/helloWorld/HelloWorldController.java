package com.in28minutes.rest.webservice.restfulwebservices.helloWorld;

import com.in28minutes.rest.webservice.restfulwebservices.helloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET,path="/helloWorld")
    @GetMapping(path = "/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-world-Path-Variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Welcome to path variable, %s", name));
    }

}
