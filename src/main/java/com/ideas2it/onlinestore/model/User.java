package com.ideas2it.onlinestore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="User")
public class User extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private long mobileNumber;
    private long alternateMobileNumber;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public long getAlternateMobileNumber() {
        return alternateMobileNumber;
    }

    public void setAlternateMobileNumber(long alternateMobileNumber) {
        this.alternateMobileNumber = alternateMobileNumber;
    }
}
