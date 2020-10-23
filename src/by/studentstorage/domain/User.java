package by.studentstorage.domain;

import java.util.Objects;

public abstract class User {
    private long inID = 1;
    private long id = inID++;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;

    public User(String login, String name, String surname, String password) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public User(long id, String login, String name, String surname, String email, String password, Role role) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public User(String login, String name, String surname, String password, Role role) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    public User(long id, String login, String name, String surname, String password, Role role) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    public User(String name, String login, String surname, String email, String password, Role role) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                role == user.role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
