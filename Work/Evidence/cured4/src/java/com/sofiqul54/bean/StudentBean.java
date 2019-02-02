
package com.sofiqul54.bean;

import com.sofiqul54.entity.Student;
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
    private String[] completedSubject;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
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

    public List<Student> getList() {
        list = new ArrayList<>();
        list = studentService.getList();
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public String[] getCompletedSubject() {
        return completedSubject;
    }

    public void setCompletedSubject(String[] completedSubject) {
        this.completedSubject = completedSubject;
    }
    
    public void save(){
    String cc = " ";
    for(String s : completedSubject){
    cc += s + " ,";
    }
    student.setSubject(cc);
    studentService.saveOrUpdate(student);
    student = new Student();
    }
    
    public void update(){
    studentService.saveOrUpdate(student);
    }
    
    public void delete(){
    studentService.delete(student);
    }
    
}
