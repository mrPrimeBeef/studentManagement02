package app.daos;

import app.entities.Course;
import app.entities.Student;
import app.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TeacherDAO implements IDAO<Teacher> {
    private static EntityManagerFactory emf;
    private static TeacherDAO instance;

    private TeacherDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static TeacherDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new TeacherDAO(emf);
        }
        return instance;
    }

    @Override
    public Teacher create(Teacher teacher) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
            return teacher;
        }

    }

    @Override
    public Teacher readById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Teacher.class, id);
        }
    }

    @Override
    public List<Teacher> readAll() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            TypedQuery query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
            return query.getResultList();
        }
    }

    public List<Course> readAllCoursesByTeacher(Teacher teacher) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE teacher.id=:id", Course.class);
            query.setParameter("id", teacher.getId());
            return query.getResultList();
        }
    }

    @Override
    public Teacher update(Teacher teacher) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(teacher);
            em.getTransaction().commit();
            return teacher;
        }
    }

    @Override
    public void delete(Teacher teacher) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(teacher);
            em.getTransaction().commit();
        }
    }
}
