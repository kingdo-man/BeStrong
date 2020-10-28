package com.kingdoman.bestrong.spring.proxy.jdk;

public class StudentServiceImpl implements StudentService {

    @Override
    public void addStudent() {
        System.out.println("add stu");
    }

    @Override
    public void updateStudent() {
        System.out.println("update stu");
    }

    @Override
    public Integer deleteStudent(int id) {
        System.out.println("delete stu");
        return 1;
    }
}
