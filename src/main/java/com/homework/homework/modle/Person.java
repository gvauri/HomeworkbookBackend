package com.homework.homework.modle;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private  Long userID;
    private  String name;
    private  String firstName;
    @Column(unique = true)
    private  String email;
    @Column(unique = true)
    private  String username;

    public Person(String email, String name, String firstName, String username){
        this.setEmail(email);
        this.setName(name);
        this.setFirstName(firstName);
        this.setUsername(username);
    }

    public Person() {

    }


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString(){
        return "Homework{" +
                "id=" +getUserID().toString()+
                ", Email='"+ getEmail().toString() + "'"+
                ", Name='"+ getName() + "'"+
                ", FirstName='"+ getFirstName().toString() + "'"+
                ", userName='"+ getUsername().toString() + "'"+
                "}";
    }
}
