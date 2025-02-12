package app.daos;

import app.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

public class CourseDao implements IDAO<Course> {

    private static CourseDao instance;
    private static EntityManagerFactory emf;

    private CourseDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static CourseDao getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new CourseDao(emf);
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

//
//    @Override
//    public List readAll() {
//        return List.of();
//    }
//
//    @Override
//    public Object update(Object o) {
//        return null;
//    }
//
//    @Override
//    public void delete(Object o) {
//
//    }
}
