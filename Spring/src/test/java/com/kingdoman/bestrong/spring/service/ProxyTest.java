package com.kingdoman.bestrong.spring.service;

import com.kingdoman.bestrong.spring.proxy.cglib.UserService;
import com.kingdoman.bestrong.spring.proxy.jdk.MyFactory;
import com.kingdoman.bestrong.spring.proxy.jdk.StudentService;
import com.kingdoman.bestrong.spring.proxy.spring.CustomerService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyTest {

    @Test
    public void test01() {
        StudentService studentService = MyFactory.createdStudentService();
        studentService.addStudent();
        studentService.deleteStudent(10);
    }

    @Test
    public void test02() {
        UserService userService = MyFactory.createdUserServiceCglib();
        userService.addUser();
        userService.deleteUser(10);
    }

    @Test
    public void test03() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beansProxyAnnotation.xml");
        CustomerService customerService = (CustomerService) context
                .getBean("customerServiceImpl");
        customerService.addCustomer();
        customerService.deleteCustomer(10);
    }
}

