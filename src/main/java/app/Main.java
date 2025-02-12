package app;

import app.config.HibernateConfig;
import app.daos.CourseDAO;
import app.daos.StudentDAO;
import app.daos.TeacherDAO;
import app.entities.Course;
import app.entities.Student;
import app.entities.Teacher;
import app.enums.CourseName;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        CourseDAO courseDAO = CourseDAO.getInstance(emf);
        TeacherDAO teacherDAO = TeacherDAO.getInstance(emf);
        StudentDAO studentDAO = StudentDAO.getInstance(emf);

        Student s1 = Student.builder().name("Rolf").email("test@test.dk").build();
        Student s2 = Student.builder().name("Jørgen").email("test@test.de").build();

        Teacher t1 = Teacher.builder().email("testy@testy.test").name("Jon").zoom("HALLO").build();
        Teacher t2 = Teacher.builder().email("testy1@testy.test").name("Thomas").zoom("HALLO").build();

        Course c1 = Course.builder().description("Coding class").courseName(CourseName.MATH).build();
        Course c2 = Course.builder().description("Here we paint").courseName(CourseName.ART).build();

        studentDAO.create(s1);
        studentDAO.create(s2);

        courseDAO.create(c1);
        courseDAO.create(c2);

        teacherDAO.create(t1);
        teacherDAO.create(t2);

//        System.out.println(teacherDAO.readById(1));

        t2.setZoom("NEW STRING");

        c1.addStudent(s1);
        c1.addStudent(s2);
        courseDAO.update(c1);

        studentDAO.readAllByCourse(c1).forEach(System.out::println);


    }
}