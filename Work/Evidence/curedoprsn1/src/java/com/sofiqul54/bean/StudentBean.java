package com.sofiqul54.bean;

import com.sofiqul54.entity.Student;
import com.sofiqul54.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Md. Sofiqul Islam, Round-37, IDB-BISEW (J2EE)
 */
@ManagedBean
@SessionScoped
public class StudentBean {
//private Student student;
//private String[] completedCourses;
//StudentService service = new StudentService();
//private List<Student> list;
//
//    public Student getStudent() {
//        if(student == null){
//        student = new Student();
//        }
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public String[] getCompletedCourses() {
//        return completedCourses;
//    }
//
//    public void setCompletedCourses(String[] completedCourses) {
//        this.completedCourses = completedCourses;
//    }
//
//    public StudentService getService() {
//        return service;
//    }
//
//    public void setService(StudentService service) {
//        this.service = service;
//    }
//
//    public List<Student> getList() {
//        list = new ArrayList<>();
//        list = service.getList();
//        return list;
//    }
//
//    public void setList(List<Student> list) {
//        this.list = list;
//    }
//
//    public void save(){
//    String cc = "";
//    for (String s : completedCourses){
//    cc += s +" ";
//    }
//    student.setCources(cc);
//    service.saveStudent(student);
//    }
//    
//    public void update(){
//    service.saveOrUpdateStudent(student);
//    }
//    
//    public void delete(){
//    
//    service.deleteStudent(student);}
StudentService service = new StudentService();
    private Student student;
    private String[] completedCourses;
    private List<Student> list;

    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }

    public Student getStudent() {
        if(student == null){
            student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String[] getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(String[] completedCourses) {
        this.completedCourses = completedCourses;
    }

    public List<Student> getList() {
        list = new ArrayList<>();
        list = service.getList();
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
    
    public void save(){
        String cc = "";
        for(String s : completedCourses){
            cc += s + " ";
        }
        student.setCourses(cc);
        service.saveStudent(student);
    }
    
    public void update(){
        service.saveOrUpdateStudent(student);
    }
    
    public void delete(){
        service.deleteStudent(student);
    }
}
