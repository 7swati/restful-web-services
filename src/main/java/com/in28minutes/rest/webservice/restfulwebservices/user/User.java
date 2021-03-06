package com.in28minutes.rest.webservice.restfulwebservices.user;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;
    private Integer id;
    @Past
    private Date birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthDate=" + birthDate +
                '}';
    }

    public User(String name, Integer id, Date birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }
}
