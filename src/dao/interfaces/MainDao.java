package dao.interfaces;

import java.util.ArrayList;

public interface MainDao<T> {
    // T type généraliste
    ArrayList<T> getAll();
    T getById(int id);
    void save(T t);
    void update(T t);
    void delete (int id);

}
