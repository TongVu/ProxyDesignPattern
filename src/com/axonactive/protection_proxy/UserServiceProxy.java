package com.axonactive.protection_proxy;

public class UserServiceProxy implements UserService{
    private boolean authenticate;
    private UserService userService;

    public UserServiceProxy(String name, boolean usrAuthenticate) {
        this.authenticate = usrAuthenticate;
        this.userService = new UserServiceImpl(name);
    }

    @Override
    public void load() {
        userService.load();
    }

    @Override
    public void loginToDoSomething() {
        if(authenticate)
            userService.loginToDoSomething();

        if(!authenticate)
            System.out.println("Access denied");
    }

    public static void main(String[] args) {
        UserService admin = new UserServiceProxy("Tong Vu", true);
        admin.load();
        admin.loginToDoSomething();

        UserService notAdmin = new UserServiceProxy("Someone else not authenticated", false);
        notAdmin.load();
        notAdmin.loginToDoSomething();
    }
}
