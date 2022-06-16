package ru.kata.spring.boot_security.demo.DTO;

public class UserDTO {

    private Long id;
    private String username;
    private String name;
    private String lastName;
    private byte age;
    private String password;

    private String[] userRoles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setUserRoles(String[] userRoles) {
        this.userRoles = userRoles;
    }

    public String[] getUserRoles() {
        return userRoles;
    }
}

