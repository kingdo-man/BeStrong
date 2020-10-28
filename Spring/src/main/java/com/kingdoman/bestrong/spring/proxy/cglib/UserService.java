package com.kingdoman.bestrong.spring.proxy.cglib;

public class UserService {

    public void addUser() {
        System.out.println("add user");
    }

    public void updateUser() {
        System.out.println("update user");
    }

    public Integer deleteUser(int id) {
        System.out.println("delete user id:" + id);
        return 1;
    }
}
