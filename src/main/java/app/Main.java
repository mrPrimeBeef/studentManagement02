package app;

import app.config.HibernateConfig;
import app.daos.CourseDao;
import app.daos.TeacherDAO;
import app.entities.Course;
import app.entities.Student;
import app.entities.Teacher;
import app.enums.CourseName;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        CourseDao courseDao = CourseDao.getInstance(emf);
        TeacherDAO teacherDAO = TeacherDAO.getInstance(emf);

        Student s1 = Student.builder().name("Rolf").email("test@test.dk").build();

        Teacher t1 = Teacher.builder().email("testy@testy.test").name("Jon").zoom("HALLO").build();
        Teacher t2 = Teacher.builder().email("testy1@testy.test").name("Thomas").zoom("HALLO").build();

        Course c1 = Course.builder().description("Coding class").courseName(CourseName.MATH).build();
        Course c2 = Course.builder().description("Here we paint").courseName(CourseName.ART).build();

        courseDao.create(c1);
        courseDao.create(c2);

        teacherDAO.create(t1);
        teacherDAO.create(t2);

//        System.out.println(teacherDAO.readById(1));

        t2.setZoom("NEW STRING");

        teacherDAO.update(t2);

        teacherDAO.delete(t2);

        teacherDAO.readAll().forEach(System.out::println);


//        c2.setDescription("Explore your creativity wiht MS Paint");
//        courseDao.update(c2);
//
//        System.out.println(courseDao.readById(1));
//
//        courseDao.delete(c1);
//
//        courseDao.readAll().forEach(System.out::println);
    }
}