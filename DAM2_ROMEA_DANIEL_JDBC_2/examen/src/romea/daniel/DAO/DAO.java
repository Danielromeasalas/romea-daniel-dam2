package src.examen.romea.daniel.DAO;

import java.util.ArrayList;

public interface DAO<T> {

    void add (T object);
    void update (T object);
    T find (int id);
    ArrayList<T> findAll();

}
