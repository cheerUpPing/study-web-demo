package com.elon.studydemo.entity;

public class User {

    private String name;

    private int age;

    public User() {

    }

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            return this.name.equals(((User) obj).name);
        } else {
            return false;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
