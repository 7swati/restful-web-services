package com.in28minutes.rest.webservice.restfulwebservices.testCRUD;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService {

    String[] skillset1 = {"java","collection","Spring"};
    UserDetails userDetails1 = new UserDetails(
            "John",
            "Pole",
            30,
            skillset1);

    UserDetails userDetails2 = new UserDetails(
            "Mac",
            "Bin",
            30,
            skillset1);

    UserDetails userDetails3 = new UserDetails(
            "User3",
            "LUser3",
            30,
            skillset1);

    List<UserDetails> listOfUser = new ArrayList<>();

    public List<UserDetails> getUserDetils(){
        listOfUser.add(userDetails1);
        listOfUser.add(userDetails2);
        listOfUser.add(userDetails3);

        return listOfUser;
    }

    public UserDetails getUserDetailsFor(String name){
        listOfUser.add(userDetails1);
        listOfUser.add(userDetails2);
        listOfUser.add(userDetails3);
        UserDetails userDetails = null;
        for(UserDetails user : listOfUser){
            if(user.getFirstName().equals(name)){
                userDetails = user;
            }
        }
        return userDetails;
    }

}
