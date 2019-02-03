package com.sofiqul54.bean;

import com.sofiqul54.enity.Student;
import com.sofiqul54.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StudentBean {
private StudentService studentService = new StudentService();
private Student student;
private List<Student> list;
private String[] completedCourses;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        if(student==null){
        student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getList() {
        list = new ArrayList<>();
        list = studentService.getList();
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public String[] getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(String[] completedCourses) {
        this.completedCourses = completedCourses;
    }

    public void save(){
    String cc = " ";
    for(String s : completedCourses){
    cc += s + " ";
    }
    student.setCompletedCourses(cc);
    studentService.saveOrUpdate(student);
    student = new Student();
    }
    
    public void edit(){
    studentService.saveOrUpdate(student);
    }
    
    public void delete(){
    studentService.delete(student);
    }
}
