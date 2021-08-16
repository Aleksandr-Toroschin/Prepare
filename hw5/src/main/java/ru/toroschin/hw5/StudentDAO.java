package ru.toroschin.hw5;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private EntityManager getEntityManager() {
        return Config.getFactory().createEntityManager();
    }

    public void insertStudent(Student student) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public void updateStudent(Student student) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    public Student getStudentById(Long id) {
        EntityManager em = getEntityManager();
        Student student = getStudentById(id, em);
        em.close();
        return student;
    }

    private Student getStudentById(Long id, EntityManager entityManager) {
        return entityManager.find(Student.class, id);
    }

    public void deleteStudentById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student student = getStudentById(id, em);
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    public List<Student> getAllStudents() {
        EntityManager em = getEntityManager();
        List<Student> students = new ArrayList<>();
        Query q = em.createQuery("from " + Student.class.getName() + " c");
        for (Object o : q.getResultList()) {
            students.add((Student) o);
        }
        em.close();
        return students;
    }

    public void insertStudents(List<Student> students) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        for (Student student: students) {
            em.persist(student);
        }
        em.getTransaction().commit();
        em.close();
    }
}
