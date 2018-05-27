package com.tsaver.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "USERS")// This tells Hibernate to make a table out of this class
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER", nullable = false)
    private Long userId;

    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ID_ROLE")
    private Long roleId;

    public User() {
        this.username = "";
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(Long userId, String username, String password, String email, Long roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Long getRoleId() {
        return roleId;
    }
}
