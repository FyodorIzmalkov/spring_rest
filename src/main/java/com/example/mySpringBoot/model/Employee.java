package com.example.mySpringBoot.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
// @Data is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields.
@Entity // @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.
public class Employee {

    private @Id
    @GeneratedValue
    Long id; // it’s the primary key and automatically populated by the JPA provider
    private String firstName;
    private String lastName;
    private String role;

    Employee() {
    }

    // a custom constructor is created when we need to create a new instance, but don’t yet have an id

    public Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }
}
