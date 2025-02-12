package app.daos;

import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Set;

public interface IDAO<T> {
    T create(T t);
    T readById(int id);
    List<T> readAll();
    T update(T t);
    void delete(T t);
}
