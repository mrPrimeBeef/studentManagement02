package app.daos;

import app.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CourseDAO implements IDAO<Course> {

    private static CourseDAO instance;
    private static EntityManagerFactory emf;

    private CourseDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static CourseDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new CourseDAO(emf);
        }
        return instance;
    }

    @Override
    public Course create(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            return course;
        }
    }

    @Override
    public Course readById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Course.class, id);
        }
    }

    @Override
    public List<Course> readAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
            return query.getResultList();
        }
    }


    @Override
    public Course update(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
            return course;
        }
    }


    @Override
    public void delete(Course course) {
        try(EntityManager em=emf.createEntityManager()){
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        }
    }
}
