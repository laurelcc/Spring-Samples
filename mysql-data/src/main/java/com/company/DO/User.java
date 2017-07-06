package com.company.DO;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by huanbenwang on 2017/7/6.
 */
@Entity
public class User {
    @Id
    private String id;

    private String name;

    private String email;

    public User(){
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String email){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
