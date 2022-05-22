package com.axonactive.protection_proxy;

public class UserServiceImpl implements UserService{
    private String name;

    public UserServiceImpl(String name) {
        this.name = name;
    }

    @Override
    public void load() {
        System.out.println(this.name + " loaded");
    }

    @Override
    public void loginToDoSomething() {
        System.out.println(this.name + " logged in");
    }
}
