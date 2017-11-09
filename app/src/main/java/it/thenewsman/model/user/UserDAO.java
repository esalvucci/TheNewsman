package it.thenewsman.model.user;

import java.util.Collection;

import it.thenewsman.model.dao.DAO;

/**
 * Created by enrico on 11/9/17.
 */
public class UserDAO implements DAO<User>{
    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public User select() {
        return null;
    }

    @Override
    public Collection<User> selectMany() {
        return null;
    }
}
