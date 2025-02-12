package app.daos;

import app.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CourseDao implements IDAO<Course>{

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
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            return course;
        }
    }

//    @Override
//    public Object read() {
//        return null;
//    }
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
