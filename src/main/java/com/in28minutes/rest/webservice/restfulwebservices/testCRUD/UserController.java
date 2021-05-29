package com.in28minutes.rest.webservice.restfulwebservices.testCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

@Autowired
UserDetailsService userDetailsService;

@GetMapping("userDetails")
    public List<UserDetails> getUserDetails(){
    return userDetailsService.getUserDetils();

    }
    @GetMapping("userDetails/{name}")
    public UserDetails getUserDetailsFor(@PathVariable("name") String userName){
        return userDetailsService.getUserDetailsFor(userName);
    }
}
