package com.kingdoman.bestrong.spring.proxy.jdk;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    void addStudent();

    void updateStudent();

    Integer deleteStudent(int id);
}
