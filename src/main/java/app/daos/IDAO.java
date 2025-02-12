package app.daos;

import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public interface IDAO<T> {
    T create(T t);
//    T read();
//    List<T> readAll();
//    T update(T t);
//    void delete(T t);

}
