package app;

import app.config.HibernateConfig;
import app.daos.CourseDao;
import app.entities.Course;
import app.entities.Student;
import app.entities.Teacher;
import app.enums.CourseName;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        CourseDao courseDao = CourseDao.getInstance(emf);

        Student s1 = Student.builder().name("Rolf").email("test@test.dk").build();
//        Teacher t1 = Teacher.builder().
        Course c1 = Course.builder().description("Coding class").courseName(CourseName.MATH).build();

        courseDao.create(c1);
    }
}