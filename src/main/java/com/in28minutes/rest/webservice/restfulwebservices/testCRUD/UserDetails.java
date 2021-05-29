package com.in28minutes.rest.webservice.restfulwebservices.testCRUD;

public class UserDetails {

    private String firstName;
    private String lastName;
    private int age;
    private String[] skills;

    public UserDetails(String firstName, String lastName, int age, String[] skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skills = skills;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}
