package com.ideas2it.onlinestore.model;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name ="Role")
public class Role extends BaseModel {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}