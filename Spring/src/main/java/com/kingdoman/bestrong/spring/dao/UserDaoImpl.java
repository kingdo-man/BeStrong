package com.kingdoman.bestrong.spring.dao;

import com.kingdoman.bestrong.spring.jdbctemplate.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Override
    public void add(User user) {
        System.out.println("添加用户");
        String sql = "insert into user (username,password) values (?,?)";
        Object[] objects = {user.getUserName(), user.getPassword()};
        getJdbcTemplate().update(sql, objects);
    }
}
