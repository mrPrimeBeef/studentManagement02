package app;

import app.config.HibernateConfig;
import app.entities.Student;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
//        DolphineDAO dolphineDao = DolphineDAO.getInstance(emf);

        Student s1 = Student.builder().name("Rolf").email("test@test.dk").build();
    }
}