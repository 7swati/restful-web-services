package com.in28minutes.rest.webservice.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 4;

    static{
        users.add(new User("Adam", 1, new Date()));
        users.add(new User("Eve", 2, new Date()));
        users.add(new User("Martha", 3, new Date()));
        users.add(new User("Jonas", 4, new Date()));

    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId()==null)
            user.setId(++userCount);

        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user: users) {
            if (id == user.getId()){
                return user;
            }
        }
        return null;
    }
    public User deleteById(int id)
    {
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            User user = it.next();
            if(user.getId()==id){
                it.remove();
                return user;
            }
        }
        return null;
    }
}
