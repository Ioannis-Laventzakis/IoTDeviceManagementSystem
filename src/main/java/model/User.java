package model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Getters and Setters

    public User() {
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User(User user) {
        this.id = user.id;
        this.name = user.name;
        this.surname = user.surname;
        this.email = user.email;
        this.password = user.password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password=" + password + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user) {
            return user.id == this.id;
        }
        return false;
    }

    public boolean equals(User user) {
        return user.id == this.id;
    }

    public boolean equals(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public boolean isEmailValid(String email) {
        return this.email.equals(email);
    }

    public boolean isPasswordValid(String password) {
        return this.password.equals(password);
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
}