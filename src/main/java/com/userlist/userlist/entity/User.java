package com.userlist.userlist.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "deleted_user")
    private boolean deletedUser = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserActivityLog> activityLogs = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, boolean deletedUser, List<UserActivityLog> activityLogs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.deletedUser = deletedUser;
        this.activityLogs = activityLogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isDeletedUser(boolean b) {
        return deletedUser;
    }

    public void setDeletedUser(boolean deletedUser) {
        this.deletedUser = deletedUser;
    }

    public List<UserActivityLog> getActivityLogs() {
        return activityLogs;
    }

    public void setActivityLogs(List<UserActivityLog> activityLogs) {
        this.activityLogs = activityLogs;
    }
}
