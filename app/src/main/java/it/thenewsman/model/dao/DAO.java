package it.thenewsman.model.dao;

import java.util.Collection;

/**
 * Created by enrico on 11/9/17.
 */

public interface DAO<T> {
    int insert(T t);
    boolean delete(T t);
    boolean update();
    T select();
    Collection<T> selectMany();
}
