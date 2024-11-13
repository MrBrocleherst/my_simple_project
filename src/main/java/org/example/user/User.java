package org.example.user;

import org.example.role.Role;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private String login;
    private String password;
    private LocalDate dateJoined;
    private String status;
    private List<Role> roles;

    public User(String name, String surname, String login, String password, LocalDate dateJoined) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.dateJoined = dateJoined;
        this.status = "non-vip";
        this.roles = new ArrayList<>();
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public long getDaysSinceJoined() {
        return ChronoUnit.DAYS.between(this.dateJoined, LocalDate.now());
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return name + " " + surname + " - Status: " + status + " - Joined: " + dateJoined + " - Roles: " +
                roles.stream().map(Role::toString).toList();
    }
}
