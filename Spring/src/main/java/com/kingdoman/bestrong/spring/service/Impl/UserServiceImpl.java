package com.kingdoman.bestrong.spring.service.Impl;

import com.kingdoman.bestrong.spring.entity.User;
import com.kingdoman.bestrong.spring.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author kingdoman
 * @date 2020/10/9
 */

@Component
public class UserServiceImpl implements UserService {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add() {
        System.out.println("创建用户" + name);
    }

    @Override
    public void add(User user) {
        System.out.println("添加用户" + user);
    }

    @Override
    public void addUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }

}
