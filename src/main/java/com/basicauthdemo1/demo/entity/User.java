package com.basicauthdemo1.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Integer age;
    private Double weight;
    private Double height;


}
