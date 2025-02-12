package app.daos;

import app.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentDAO implements IDAO<Student> {
    private static EntityManagerFactory emf;
    private static StudentDAO instance;

    private StudentDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public StudentDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new StudentDAO(emf);
        }
        return instance;
    }

    @Override
    public Student create(Student student) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            return student;
        }
    }

    @Override
    public Student readById(int id) {
        try(EntityManager em = emf.createEntityManager()){
            return em.find(Student.class,id);
        }
    }

    @Override
    public List<Student> readAll() {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s",Student.class);
            return query.getResultList();
        }
    }

    @Override
    public Student update(Student student) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
            return student;
        }
    }

    @Override
    public void delete(Student student) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }
    }
}
