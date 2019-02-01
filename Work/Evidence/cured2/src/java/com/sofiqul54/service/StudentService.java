package com.sofiqul54.service;

import com.sofiqul54.entity.Student;
import com.sofiqul54.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author IDB-BISEW (J2EE)
 */
public class StudentService {

    public void saveStudent(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    public void saveOrUpdate(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        transaction.commit();
    }

    public void deleteStudent(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
    }

    public List<Student> getList() {
        List<Student> list = new ArrayList<>();

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            list = session.createQuery("FROM Student").list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return list;

    }
}
