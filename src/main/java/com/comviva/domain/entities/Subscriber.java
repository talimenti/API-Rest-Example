package com.comviva.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "SUBSCRIBER")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;
    @Column(name = "NAME")
    public String name;
    @Column(name = "PHONE")
    public String telephone;
    @Column(name = "EMAIL")
    public String email;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}