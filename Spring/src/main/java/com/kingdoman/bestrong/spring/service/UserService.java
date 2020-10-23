package com.kingdoman.bestrong.spring.service;

import com.kingdoman.bestrong.spring.entity.User;

/**
 * @author kingdoman
 * @date 2020/10/9
 */

public interface UserService {

    void add();

    void add(User user);

    void addUser();

    void updateUser();

    void deleteUser();
}
