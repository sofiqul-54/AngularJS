package com.sofiqul54.service;

import com.sofiqul54.entity.Student;
import com.sofiqul54.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class StudentService {

    public void saveOrUpdate(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        transaction.commit();
    }

    public void delete(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
    }

    public static List<Student> getList() {
        List<Student> student = new ArrayList<>();

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            student = session.createQuery("FROM Student").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

}
