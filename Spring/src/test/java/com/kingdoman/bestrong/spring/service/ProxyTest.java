package com.kingdoman.bestrong.spring.service;

import com.kingdoman.bestrong.spring.proxy.jdk.StuFactory;
import com.kingdoman.bestrong.spring.proxy.jdk.StudentService;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void test01() {
        StudentService studentService = StuFactory.createdStudentService();
        studentService.addStudent();
        studentService.deleteStudent(10);
    }
}

