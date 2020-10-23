package com.kingdoman.bestrong.spring.service;

import com.kingdoman.bestrong.spring.service.Impl.UserServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author kingdoman
 * @date 2020/10/9
 */

@Service
public class UserServiceFactory1 {

    public static UserServiceImpl createUserService() {
        return new UserServiceImpl();
    }
}
