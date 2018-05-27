package com.tsaver.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name="ROLES")// This tells Hibernate to make a table out of this class
@Component
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_ROLE", nullable = false)
    private Long roleId;

    @Column(name = "NAME")
    private String name;

    public Role(){
        this.name = "";
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }
}
